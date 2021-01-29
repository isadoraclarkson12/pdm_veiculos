package com.example.rec_pdm;

import java.util.Objects;

public class ItemList<T extends Comparable<T>> implements Comparable<ItemList<T>> {
    public T item;
    public boolean expanded;
    public boolean selected;

    public ItemList(T item) {
        this.item = item;
        this.expanded = false;
        this.selected = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemList<?> itemList = (ItemList<?>) o;
        return Objects.equals(item, itemList.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public int compareTo(ItemList<T> o) {
        return item.compareTo(o.item);
    }
}
