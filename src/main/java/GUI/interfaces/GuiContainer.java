package gui.interfaces;

/**
 * interface GuiContainer defines the typical interactions
 * expected for a gui container such as a window or panel.
 * {@inheritDoc}
 */
public interface GuiContainer extends Renderable,JGuiConvertible {

    /**
     * Adds a JGuiConvertible object to the container
      * @param guiObject
     */
    void add(JGuiConvertible guiObject);

    /**
     *
     * @param guiObject Adds an array of GUI objects to the container
     * @param vGap Specifies the vertical spacing between elements.
     */
    void add(JGuiConvertible[] guiObject, int vGap);




}
