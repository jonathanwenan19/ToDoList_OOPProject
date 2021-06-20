package sample;

public class Data implements ToString
{
    private String header;
    private String date;
    private String info;


    public Data(String header, String date, String info)
    {
        this.header = header;
        this.date = date;
        this.info = info;
    }


    public String getHeader() {
        return header;
    }

    public String getInfo() {
        return info;
    }

    public String getDate() {
        return date;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    @Override
    public void toStringheader()
    {
     System.out.println(header);
    }

    @Override
    public void toStringDate()
    {
        System.out.println(date);
    }

    @Override
    public void toStringBody()
    {
        System.out.println(info);
    }

}
