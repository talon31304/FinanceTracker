package GUI.interfaces;

/**
 * Created by Rick on 9/27/2014.
 * Describes the simplest window object or control
 */
public interface BoxedItem extends Box,Item{
   // void add(ContentItem subContent);
   void add(BoxedItem innerBox);
    void addAt(BoxedItem innerBox, int hPos, int vPos);
    void add(BoxedItem[] innerBoxes, int vGap);
    boolean hasBoxes();



}
