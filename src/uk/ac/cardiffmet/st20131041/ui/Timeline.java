package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import uk.ac.cardiffmet.st20131041.domain.model.Event;

/**
 * JPanel that holds the time line.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class Timeline extends JPanel {

    /**
     * An ArrayList of Events that are displayed on the time line
     */
    private ArrayList<Event> allEvents;

    /**
     * The with that is used for displaying one day
     */
    private int dayWidth = 40;

    /**
     * The X-coordinate of the origin
     */
    private int originX = 40;

    /**
     * The Y-coordinate of the origin
     */
    private int originY = 280;

    /**
     * The number of days in the given year (think about leap years)
     */
    private int nrDays;

    /**
     * The year that the time line is drawn
     */
    private int year;

    /**
     * The height of the label displaying the event
     */
    private int labelHeight = 50;

    /**
     * Creates new form AddEventPanel and initializes all its components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing. It is also used for testing purpose
     */
    public Timeline() {
        this.setLayout(null);
        //testing purpose
        this.setYear(120);
        this.allEvents = new ArrayList<Event>();
        this.calculateNrDays();
        determineYOrigin();
        this.setPreferredSize(new Dimension((originX * nrDays) + 125, originY + 150));
    }

    /**
     * Constructor that hold accepts the events and the year.
     *
     * @param allEvents an ArrayList of all the events in the given year.
     * @param year the year for which the time line is drawn
     */
    public Timeline(ArrayList<Event> allEvents, int year) {
        this.setLayout(null);
        this.setYear(year);
        this.allEvents = allEvents;
        this.calculateNrDays();
        determineYOrigin();
        this.setPreferredSize(new Dimension((originX * nrDays) + 125, originY + 150));
    }

    /**
     * Gets all the events of the time line.
     *
     * @return ArrayList of events
     */
    private ArrayList<Event> getAllEvents() {
        return allEvents;
    }

    /**
     * Calculates and sets the originY.
     */
    public void determineYOrigin() {
        int overlaps = this.maxNumberOfoverlaps();
        if (overlaps > 4) {
            this.originY += (labelHeight) * (overlaps - 4);
            //verandert
            this.setPreferredSize(new Dimension((originX * nrDays) + 125, originY + 150));
        }
    }

    /**
     * Sets allEvents that will be used on the time line.
     *
     * @param allEvents
     */
    public void setAllEvents(ArrayList<Event> allEvents) {
        this.allEvents = allEvents;
    }

    /**
     * Gets the day width
     *
     * @return Width of one day
     */
    public int getDayWidth() {
        return dayWidth;
    }

    /**
     * Gets the Y-origin.
     *
     * @return Y-origin
     */
    public int getOriginY() {
        return originY;
    }

    /**
     * Gets the height of a label
     *
     * @return height of a label
     */
    public int getLabelHeight() {
        return labelHeight;
    }

    /**
     * Overrides the paintComponent. Draws the Y-axis. Draws the Y-axis label.
     * Draws the X-axis label.
     *
     * @param g
     */
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

    /**
     * Draws the the x-axis and the partitioning of the days on this axis.
     *
     * @param g Graphics2D object used to draw.
     */
    private void drawDayLengths(Graphics2D g) {
        for (int i = 0; i <= this.nrDays; i++) {
            g.draw(new Line2D.Double(40.0 + (dayWidth * i), originY - 10, 40.0 + (dayWidth * i), originY + 10));
        }
        g.draw(new Line2D.Double(40.0, originY, 80 + (this.nrDays * dayWidth), originY));
    }

    /**
     * Draws all the the date labels on the correct position and transformation
     * on the time line.
     *
     * @param g Graphics2D object used to draw
     */
    private void drawDateOnLine(Graphics2D g) {
        GregorianCalendar cal = new GregorianCalendar(this.getYear(), 0, 1);
        g.transform(AffineTransform.getTranslateInstance(35, 0));
        g.transform(AffineTransform.getRotateInstance(90.0 * (Math.PI / 180.0)));
        g.setColor(Color.BLACK);
        for (int i = 0; i <= this.nrDays; i++) {
            if (isWeekend(cal)) {
                g.setColor(Color.red);
            }
            g.drawString(this.format(cal), originY + 20, i * (-dayWidth));
            cal.add(Calendar.DATE, 1);
            g.setColor(Color.BLACK);
        }

    }

    /**
     * Checks if a year is a leap year.
     *
     * @param year
     * @return <code>true</code> is the year is a leap year. <code>false</code>
     * if the year is not a leap year.
     */
    private boolean isLeapYear(int year) {
        GregorianCalendar cal = new GregorianCalendar();
        return cal.isLeapYear(year);
    }

    /**
     * Calculates the number of days in the year of the time line object. Sets
     * the correct number of days.
     *
     */
    private void calculateNrDays() {
        if (this.isLeapYear(this.getYear())) {
            this.nrDays = 365;
        } else {
            this.nrDays = 366;
        }
    }

    /**
     * Formats the GregorianCalendar Date to a format of 'EE DD MMM'. for
     * example 'Wed 1 JAN'.
     *
     * @param calendar the Gregorian calendar object
     * @return the date formatted as the correct string
     */
    private String format(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("EE dd MMM");
        fmt.setCalendar(calendar);
        String dateFormatted = fmt.format(calendar.getTime());
        return dateFormatted;
    }

    /**
     * Checks if the calendar object is in the weekend
     *
     * @param calendar
     * @return if it is weekend or not.
     */
    private boolean isWeekend(GregorianCalendar cal) {
        if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the year of the time line.
     *
     * @return the year of the time line
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the time line.
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year - 1900;
    }

    /**
     * Calculates what the maximum number of overlaps is in the ArrayList of all
     * events.
     *
     * @return maximum number of overlaps in the ArrayList
     */
    public int maxNumberOfoverlaps() {
        int result = 0;
        int i = 0;
        if (this.getAllEvents() != null) {
            for (Event e : this.getAllEvents()) {
                int numberOfOverlaps = numberOfOverlaps(i);
                int numberOfCumulativeOverlaps = this.numberOfCumulativeOverlaps(i);
                if (numberOfOverlaps > result) {
                    result = numberOfOverlaps;
                }
                if (numberOfCumulativeOverlaps > result) {
                    result = numberOfCumulativeOverlaps;
                }
                i++;
            }
        }
        return result;
    }

    /**
     * Calculate the number of blocks between two numbers.
     *
     * @param start startDate of an event
     * @param end enDate of an event
     * @return the number of blocks
     */
    public int numberOfBlocks(Date start, Date end) {
        return (int) ((end.getTime() - start.getTime()) / 86400000) + 1;
    }

    /**
     * Check if the endDate overlaps with the startDate of another event.
     *
     * @param endEvent1 start Date of an event
     * @param startEvent2 end Date of an event
     * @return true if it overlaps, false if it didn't overlap
     */
    private boolean overLapWithPreviousDate(Date endEvent1, Date startEvent2) {
        boolean overlap;
        if (endEvent1.after(startEvent2) || (!endEvent1.after(startEvent2) && !endEvent1.before(startEvent2))) {
            overlap = true;
        } else {
            overlap = false;
        }
        return overlap;
    }

    /**
     * Calculates the number of Overlaps the event at position 'numberOfEvent'
     * has in the ArrayList. An event overlaps another event if the startDate
     * overlaps with the previous endDate. If it overlaps with the previous
     * event we have to keep checking with the previous events if they also
     * overlap.
     *
     * @param numberOfEvent the number of the position in the arraylist
     * @return the cumulative value that the events overlapped.
     */
    public int numberOfOverlaps(int numberOfEvent) {
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

    /**
     * Calculates if some previous events overlaps. If it overlaps with the
     * current event we have to check how much the previous events overlaps and
     * add 1 because has to be 1 higher.
     *
     * @param numberOfEvent
     * @return the cumulative value that the events overlapped
     */
    public int numberOfCumulativeOverlaps(int numberOfEvent) {
        int result = 0;
        if (numberOfEvent != 0) {
            int previousEventNumber = numberOfEvent - 1;
            Event currentEvent = this.getAllEvents().get(numberOfEvent);
            while (previousEventNumber >= 0) {
                Event preciousEvent = this.getAllEvents().get(previousEventNumber);
                if (overLapWithPreviousDate(preciousEvent.getEndDate(), currentEvent.getStartDate())) {
                    //result++;
                    int tempResult = this.numberOfOverlaps(previousEventNumber) + 1;
                    if (tempResult > result) {
                        result = tempResult;
                    }
                }
                previousEventNumber--;
            }
        }
        return result;
    }

}
