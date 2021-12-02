package miniProject;


import java.util.ArrayList;
import java.util.Collections;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		// creating the Javalin object that we can use
		Javalin app = Javalin.create();
		
		// starting the Javalin app
		// (opening up to receive requests)
		app.start();
		ArrayList<String> collection = new ArrayList<String>();
		// if we get a request with the "POST" method
		// and the URI ends with "/collect"
		app.post("/collect", ctx -> {
			// get the item from the request body
			String item = ctx.body().replaceFirst("item=", "");

			collection.add(item);

			ctx.html("<script>window.history.go(-1);</script>");

		});
		
		app.get("/display", ctx-> {
			int count = 1;
			String responseText = "";
			for(String item: collection)
			{
				responseText += ("Item " + count + ": " + item + "\n");
				count++;
			}		
			ctx.result(responseText);
		});
	}


}
