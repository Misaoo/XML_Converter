package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("name")
public class Name {
    public String name;
    public String born;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
}
