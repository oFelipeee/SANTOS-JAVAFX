module NikeJavaFxx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
}
