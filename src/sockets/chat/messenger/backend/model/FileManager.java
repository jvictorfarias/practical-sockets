package sockets.chat.messenger.backend.model;

import java.io.Serializable;
import java.util.Date;

public class FileManager implements Serializable {
    private byte[] content;
    private transient long length;
    private transient Date dataHoraUpload;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public Date getDataHoraUpload() {
        return dataHoraUpload;
    }

    public void setDataHoraUpload(Date dataHoraUpload) {
        this.dataHoraUpload = dataHoraUpload;
    }
}
