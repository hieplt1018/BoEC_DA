package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2019-05-04T18:47:53")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Long> ordersID;
    public static volatile SingularAttribute<Bill, Float> cost;
    public static volatile SingularAttribute<Bill, Integer> customerID;
    public static volatile SingularAttribute<Bill, String> billStatus;
    public static volatile SingularAttribute<Bill, String> paymentMethod;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Integer> staffID;
    public static volatile SingularAttribute<Bill, Date> createDate;

}