package uk.ac.cardiffmet.st20131041.ui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * A custom FileTypeFilter, for looking at at files with extension an
 * description.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class FileTypeFilter extends FileFilter {

    /**
     * The extension of the file
     */
    private final String extension;
    /**
     * the file description of the file type
     */
    private final String description;

    /**
     * Creating a fileTypeFilter can be done by giving the description and
     * corresponding extension
     *
     * @param extension
     * @param description
     */
    public FileTypeFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }

    /**
     * {@inheritdoc}
     * 
     * It accepts directories and files with the given extension.
     *
     * @param f Given/selected file
     * @return if it can be accepted
     */
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        return f.getName().endsWith(extension);
    }

    /**
     * Gets the description with the extension in brackets.
     * 
     * @return a custom description with the extension in brackets.
     */
    @Override
    public String getDescription() {
        return description + String.format(" (*%s)", extension);
    }

}
