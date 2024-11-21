module org.yesserm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens org.yesserm to javafx.fxml;
    opens org.yesserm.controller to javafx.fxml;
    opens org.yesserm.entity to org.hibernate.orm.core;
    exports org.yesserm;
}
