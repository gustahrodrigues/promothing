package controllers;

import static play.libs.Json.toJson;
import models.Product;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class ProductController extends Controller {
	
	@BodyParser.Of(play.mvc.BodyParser.Json.class)
	public static Result postProduct() {
		JsonNode json = request().body().asJson();
		Product newProduct = Json.fromJson(json, Product.class);

		if(newProduct.deveSalvar()){
			newProduct.save();
		}

		return ok(toJson(newProduct)); 
	}
	
	public static Result getProducts() {
		return ok(toJson(Product.find.all()));
	}

	public static Result getProduct(String id){
		Product product = Product.find.byId(id);

		if(product == null){
			return notFound();
		}

		return ok(toJson(product));
	}
	
	public static Result deleteProduct(String id){
		Product product = Product.find.byId(id);

		if(product == null){
			return notFound();
		}

		product.delete();
		
		return ok();
	}
	
	public static Result addProduct() {
        Form<Product> form = form(Product.class).bindFromRequest();
        Product product = form.get();
        product.save();
        return redirect(routes.Application.index());
    }

}
