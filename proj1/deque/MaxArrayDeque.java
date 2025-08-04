package deque;

import java.util.Comparator;


public class MaxArrayDeque<T> extends ArrayDeque<T>{
    public Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c){ //带有自定义比较器的构造函数
        super();
        this.cmp = c;
    }

    public T max(){
        return max(this.cmp);
    }

    public T max(Comparator<T> c){
        if(isEmpty()) return null;
        else{
        T max = super.get(0);
        for(int i=0;i<size;i++){
            if(c.compare(super.get(i),max)>0){
                max = super.get(i);//不需换位，直接改变max
                }
            }
        return max;
        }
    }
}
