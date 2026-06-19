package com.scotputnam.SetMaps;

import java.util.Objects;

public class Sku implements Comparable<Sku>{
    private final String sku;
    private final int code;

    public Sku(String sku, int code) {
        this.sku = sku;
        this.code = code;
    }

    @Override
    public int compareTo(Sku o){
        return this.sku.compareTo(o.sku);
    }


}
