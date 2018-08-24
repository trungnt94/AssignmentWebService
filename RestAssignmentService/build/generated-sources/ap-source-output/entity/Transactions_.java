package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-24T01:05:40")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Integer> senderid;
    public static volatile SingularAttribute<Transactions, Integer> receiverid;
    public static volatile SingularAttribute<Transactions, Date> transactiondate;
    public static volatile SingularAttribute<Transactions, Integer> transactionfee;
    public static volatile SingularAttribute<Transactions, String> billid;
    public static volatile SingularAttribute<Transactions, Integer> sendamount;
    public static volatile SingularAttribute<Transactions, String> transactionname;
    public static volatile SingularAttribute<Transactions, Integer> id;
    public static volatile SingularAttribute<Transactions, Integer> transactionamount;
    public static volatile SingularAttribute<Transactions, Integer> receiveamount;

}