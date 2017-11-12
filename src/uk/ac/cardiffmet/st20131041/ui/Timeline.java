package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;

/**
 *
 * @author Dries Janse
 */
public class Timeline extends JPanel {

    private ArrayList<Event> allEvents;
    private final int dayWidth = 40;
    private final int originX = 40;
    private final int originY = 280;
    private int nrDays;
    private int year;
    private final int labelHeight = 50;

    public Timeline() {
        //testing purpose
        allEvents = new ArrayList<>();
        Event event1 = new Event("Title1", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(2020, 00, 02), new Date(2020, 00, 03));
        Event event2 = new Event("Title2", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(2020, 00, 03), new Date(2020, 00, 10));
        Event event3 = new Event("Title3", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(2020, 00, 07), new Date(2020, 00, 12));
        Event event4 = new Event("Title4", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(2020, 00, 12), new Date(2020, 00, 24));
        Event event5 = new Event("Title5", "Description", new Location("country", "postcode", "streetName", "houseNumber"), new Date(2020, 00, 26), new Date(2020, 00, 27));
        allEvents.add(event1);
        allEvents.add(event2);
        allEvents.add(event3);
        allEvents.add(event4);
        allEvents.add(event5);

        this.setLayout(null);
        this.setYear(2020);
        this.calculateNrDays();
        this.setPreferredSize(new Dimension((originX * nrDays) + 125, originY + 150));
        drawEventsOnLine();
    }

    public Timeline(ArrayList<Event> allEvents, int year) {
        this.setLayout(null);
        this.setYear(year);
        this.allEvents = allEvents;
        this.calculateNrDays();
        this.setPreferredSize(new Dimension((originX * nrDays) + 125, originY + 150));
        drawEventsOnLine();
    }

    private ArrayList<Event> getAllEvents() {
        return allEvents;
    }

    private void drawEventsOnLine() {
        int i = 0;
        for (Event e : allEvents) {
            JLabel label = new JLabel(e.getTitle(), SwingConstants.CENTER);
            label.setFont(new java.awt.Font("Yu Gothic UI", 3, 17));
            this.add(label);
            int nrDays = this.numberOfBlocks(e.getStartDate(), e.getEndDate());
            int offset = this.numberOfBlocks(new Date(this.year, 00, 01), e.getStartDate()) - 1;
            label.setLocation(40 + (offset * dayWidth), originY - labelHeight - (numberOfOverlaps(i) * labelHeight));
            label.setSize((nrDays) * dayWidth, labelHeight);
            label.setOpaque(true);
            label.setBackground(new Color(119,171,89));
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            label.setBorder(border);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt){
                    
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setBackground(new Color(201,223,138));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setBackground(new Color(119,171,89));
                }
                                
            });
            i++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Save transformations
        AffineTransform restoreTransform = g2.getTransform();

        // Clear background
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, (originX * nrDays) + 250, originY + 180);

        // Draw axis lines
        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(40.0, 20.0, originX, originY));

        // Draw horziontal axe + day partioning
        drawDayLengths(g2);

        // Draw axis labels
        Font F = new Font("Consolas", Font.PLAIN, 18);
        g2.setFont(F);

        // Draw rotated label on y axis		
        g2.transform(AffineTransform.getTranslateInstance(35, 80));
        g2.transform(AffineTransform.getRotateInstance(-90.0 * (Math.PI / 180.0)));
        g2.drawString("Events", 0, 0);

        //reset Transformation
        g2.setTransform(restoreTransform);
        //draw dates on line
        this.drawDateOnLine(g2);
        //reset Transformation
        g2.setTransform(restoreTransform);
    }

    private void drawDayLengths(Graphics2D g) {
        for (int i = 0; i <= this.nrDays; i++) {
            g.draw(new Line2D.Double(40.0 + (dayWidth * i), 270.0, 40.0 + (dayWidth * i), 290.0));
        }
        g.draw(new Line2D.Double(40.0, 280.0, 80 + (this.nrDays * dayWidth), 280.0));
    }

    private void drawDateOnLine(Graphics2D g) {
        GregorianCalendar cal = new GregorianCalendar(this.getYear(), 0, 1);
        g.transform(AffineTransform.getTranslateInstance(35, 0));
        g.transform(AffineTransform.getRotateInstance(90.0 * (Math.PI / 180.0)));
        for (int i = 0; i <= this.nrDays; i++) {
            g.drawString(this.format(cal), originY + 20, i * (-dayWidth));
            cal.add(Calendar.DATE, 1);
        }

    }

    private boolean isLeapYear(int year) {
        GregorianCalendar cal = new GregorianCalendar();
        return cal.isLeapYear(year);
    }

    private void calculateNrDays() {
        if (this.isLeapYear(this.getYear())) {
            this.nrDays = 365;
        } else {
            this.nrDays = 366;
        }
    }

    private String format(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM");
        fmt.setCalendar(calendar);
        String dateFormatted = fmt.format(calendar.getTime());
        return dateFormatted;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int numberOfBlocks(Date start, Date end) {
        return (int) ((end.getTime() - start.getTime()) / 86400000) + 1;
    }

    private boolean overLapWithPreviousDate(Date endEvent1, Date startEvent2) {
        boolean overlap;
        if (endEvent1.after(startEvent2) || (!endEvent1.after(startEvent2) && !endEvent1.before(startEvent2))) {
            overlap = true;
        } else {
            overlap = false;
        }
        return overlap;
    }

    private int numberOfOverlaps(int numberOfEvent) {
        int result = 0;
        if (numberOfEvent != 0) {
            int currentComparer = numberOfEvent - 1;
            Event previousEvent = this.getAllEvents().get(currentComparer);
            Event currentEvent = this.getAllEvents().get(numberOfEvent);
            boolean keepDoing = true;
            while (keepDoing) {
                if (overLapWithPreviousDate(previousEvent.getEndDate(), currentEvent.getStartDate())) {
                    result++;
                    currentComparer--;
                    if (currentComparer >= 0) {
                        previousEvent = this.getAllEvents().get(currentComparer);
                        currentEvent = this.getAllEvents().get(currentComparer + 1);
                    } else {
                        keepDoing = false;
                    }
                } else {
                    keepDoing = false;
                }
            }
        }
        return result;
    }
}
