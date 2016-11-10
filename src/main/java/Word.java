import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Word {

    @XmlElement(name = "english")
    String english;

    @XmlElement(name = "russian")
    String russian;

    public Word() {
    }

    public Word(String english, String russian) {
        this.english = english;
        this.russian = russian;
    }

    @Override
    public String toString() {
        return "Word{" +
                "english='" + english + '\'' +
                ", russian='" + russian + '\'' +
                '}';
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }
}
