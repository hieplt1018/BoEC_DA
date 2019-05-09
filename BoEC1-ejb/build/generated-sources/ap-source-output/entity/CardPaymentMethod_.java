package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-05T20:18:59")
@StaticMetamodel(CardPaymentMethod.class)
public class CardPaymentMethod_ { 

    public static volatile SingularAttribute<CardPaymentMethod, String> cartNumber;
    public static volatile SingularAttribute<CardPaymentMethod, Integer> webAccountID;
    public static volatile SingularAttribute<CardPaymentMethod, String> cartPaymentType;
    public static volatile SingularAttribute<CardPaymentMethod, Date> expiredDate;
    public static volatile SingularAttribute<CardPaymentMethod, Integer> ccv;
    public static volatile SingularAttribute<CardPaymentMethod, Integer> id;
    public static volatile SingularAttribute<CardPaymentMethod, Integer> addressID;

}