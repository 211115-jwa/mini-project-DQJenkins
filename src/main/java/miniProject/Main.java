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
		ArrayList<Game> collection = new ArrayList<Game>();
		
		// if we get a request with the "POST" method
		// and the URI ends with "/collect"
		app.post("/collect", ctx -> {
			Game game = new Game();
			
			game.setTitle(ctx.formParam("title"));
			game.setPlatform(ctx.formParam("platform"));
			game.setEsrbRating(ctx.formParam("rating"));
			game.setPrice(Float.parseFloat(ctx.formParam("price")));

			collection.add(game);

			//Sends the browser back one page in history to the page they came from
			ctx.html("<script>window.history.go(-1);</script>");
		});
		
		app.get("/display", ctx-> {
			int count = 1;
			String responseText = "";
			for(Game game: collection)
			{
				responseText += ("Item " + count + ": " + game + "\n");
				count++;
			}		
			ctx.result(responseText);
		});
	}


}
