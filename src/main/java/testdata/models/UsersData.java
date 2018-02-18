package testdata.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersData implements Serializable {
    @XmlElement(name = "user", type = User.class)
    private List<User> userDataSet;

    public UsersData() {
    }

    public UsersData(List<User> userDataSet) {
        this.userDataSet = userDataSet;
    }


    public List<User> getUserDataSet() {
        return userDataSet;
    }

    public void setUserDataSet(List<User> userDataSet) {
        this.userDataSet = userDataSet;
    }
}
