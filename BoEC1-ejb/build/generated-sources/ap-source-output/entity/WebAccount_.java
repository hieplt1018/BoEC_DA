package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-04T18:47:53")
@StaticMetamodel(WebAccount.class)
public class WebAccount_ { 

    public static volatile SingularAttribute<WebAccount, String> password;
    public static volatile SingularAttribute<WebAccount, Integer> id;
    public static volatile SingularAttribute<WebAccount, String> username;
    public static volatile SingularAttribute<WebAccount, Date> createDate;

}