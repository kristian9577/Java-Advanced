package ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListIterator {
    private static final int INIT_INDEX = -1;

    private List<String> data;
    private int index;

    public ListIterator(ArrayList<String> data) {
        this.data = data;
        this.setIndex();
    }

    private void setIndex() {
        if (this.data.size() == 0) {
            this.index = ListIterator.INIT_INDEX;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }
    public String print(){
        if(this.data.size()==0){
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        return this.data.get(this.index);
    }

    public boolean hasNext(){
        return this.index<this.data.size()-1;
    }
}
