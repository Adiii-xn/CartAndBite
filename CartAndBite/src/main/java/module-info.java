module com.system.cartandbite {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;

    opens com.system.CartAndBiteMain to javafx.fxml;
    opens com.system.LoginAndCreate to javafx.fxml;

    opens com.system.AdminPack to javafx.fxml;
    opens com.system.AdminPack.AdminDashboard to javafx.fxml;
    opens com.system.AdminPack.AdminProduct to javafx.fxml;
    opens com.system.AdminPack.AdminRider to javafx.fxml;

    opens com.system.CustomersPack to javafx.fxml;
    opens com.system.Logout to javafx.fxml;

    exports com.system.CartAndBiteMain;
    exports com.system.LoginAndCreate;
    exports com.system.AdminPack;
    exports com.system.AdminPack.AdminDashboard;
    exports com.system.AdminPack.AdminProduct;
    exports com.system.AdminPack.AdminRider;

    exports com.system.CustomersPack;
    exports com.system.Database;
    exports com.system.Logout;
}