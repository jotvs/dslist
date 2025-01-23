package com.jotvs.dslist.projection;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer position ();
}
