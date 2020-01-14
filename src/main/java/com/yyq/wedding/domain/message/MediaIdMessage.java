package com.yyq.wedding.domain.message;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yyq.wedding.annotation.XStreamCDATA;

public class MediaIdMessage {
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
