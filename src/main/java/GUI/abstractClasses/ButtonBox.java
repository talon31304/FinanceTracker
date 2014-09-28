package GUI.abstractClasses;

import GUI.interfaces.BoxedItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Rick on 9/27/2014.
 */
public  abstract class ButtonBox extends BaseBox{
    private String Title;
    public final void add(BoxedItem innerBox) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public final void addAt(BoxedItem  innerBox, int hPos, int vPos) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public final void add(BoxedItem [] innerBoxes, int vGap) throws NotImplementedException{
        throw new NotImplementedException();
    }
    public  final boolean hasBoxes(){
        return false;
    }


}




