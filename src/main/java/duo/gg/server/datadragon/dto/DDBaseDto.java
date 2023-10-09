package duo.gg.server.datadragon.dto;

public class DDBaseDto<T> {
    public String type;
    public String format;
    public String version;
    public T data;
}
