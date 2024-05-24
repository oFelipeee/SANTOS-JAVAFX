module NikeJavaFxx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens model to javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
}
