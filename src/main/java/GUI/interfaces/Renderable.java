package gui.interfaces;

/**
 *Renderable defines a typical set of interactions that classes representing a graphical object might need.
 * Items such as background color, size, position, etc
 */
public interface Renderable {
    /**
     * Sets the size of the object in pixels
     * @param hSize Sets the width of the object in pixels
     * @param vSize Sets the height of the object in pixels
     */
    void setSize(int hSize, int vSize);


    /**
     *
     * @param hLocation Sets the vertical location of the the top left corner of the object
     *                  from the top left corner of container.
     * @param vLocation Sets the horizontal location of the the top left corner of the object
     *                  from the top left corner of container.
     */
    void setLocation(int hLocation, int vLocation);

    /**
     * Sets the visibility of the object
     * @param isVisible A boolean value setting the object visible if true, invisible if false.
     */
    void setVisible(boolean isVisible);

    /**
     * Sets the background color to the given hex color code.
     * @param hexColor A hex color code.
     */
    void setBackgroundColor(String hexColor);

    /**
     * Sets the width of the border in pixels
     * @param widthPx The width of the border in pixels
     */
    void setBorderWidth(int widthPx);

    /**
     * Sets the title of the object to the given string.
     * @param title The title of the object.
     */
    void setTitle(String title);

    /**
     * Returns the title of the object
     * @return Returns the title of the object
     */
    String getTitle();

    /**
     * Returns the width of the object.
     * @return Returns the width of the object.
     */
    int getHSize();

    /**
     * Returns the height of the object.
     * @return Returns the height of the object.
     */
    int getVSize();


    /**
     * Returns the visibility of the object.
     * @return Returns true if teh object is visible or false otherwise.
     */
    boolean isVisible();

    /**
     * Sets the object as enabled or disabled.
     * @param enabled A boolean value, sets the object visible if true, false otherwise.
     */
    void  setEnabled(boolean enabled);

    /**
     * Returns the enabled status of the object.
     * @return Returns true if the object is enabled or false otherwise.
     */
    boolean isEnabled();
}
