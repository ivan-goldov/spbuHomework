package group144.goldov;

/** List that doesn't contain equal elements */
public class UniqueList <T> extends GenericLinkedList<T> {

    /** A method that adds new element to the list */
    @Override
    public void add(T value) throws ElementAlreadyInTheListException {
        if (super.find(value) != -1) {
            throw new ElementAlreadyInTheListException("You're trying to add element that's already in the list");
        }
        super.add(value);
    }


    /** A method that adds new element to the list at the certain index */
    @Override
    public void add(T value, int index) throws ElementAlreadyInTheListException, IndexOutOfBoundsException {
        if (index > super.getLength() || index < 0) {
            throw new IndexOutOfBoundsException("You entered invalid index");
        }
        if (super.find(value) != -1) {
            throw new ElementAlreadyInTheListException("You're trying to add element that's already in the list");
        }
        super.add(value, index);
    }

    /** A method that removes element from the list */
    public boolean remove(T value) throws ElementIsNotInTheListException {
        if (super.find(value) == -1) {
            throw new ElementIsNotInTheListException("You're trying to remove element that's not in the list");
        }
        return super.remove(value);
    }

}
