package util;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    @Override
    public String toString(){
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        var other = (Pair<?>) obj;
        return first.equals(other.first) && second.equals(other.second);
    }

    @Override
    public int hashCode(){
        return first.hashCode() + second.hashCode();
    }

}
