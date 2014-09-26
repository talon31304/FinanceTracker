package GUI;

/**
 * Created by Rick on 9/26/2014.
 */
public interface DataView {
    void render();
    void  refresh();
    void clear();
    void enabled(boolean isEnabled);
    boolean isEnabled();
    void visible(boolean isVisible);
    boolean isVisible();

    int getWidth();
    void setWidth(int widthPx);
    int getHeight();
    void setHeight(int heightPx);
    void setPagination(boolean enablePagination);
    boolean isPaginationEnabled();
    int getBorderWidth();
    void setBorderWidth(int borderWidth);
    void setBorderColor(String hexColorString);
    String getBorderColor();
    void setBackgroundColor(String hexColorString);
    String getBackgroundColor();
}
