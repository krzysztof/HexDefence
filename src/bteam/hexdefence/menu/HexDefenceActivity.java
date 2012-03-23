package bteam.hexdefence.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

public class HexDefenceActivity extends Activity {
    /** Called when the activity is first created. */
	private Menu main_menu;
	private Menu ustawienia_menu;
	private MenuItem menu_hex_team;
	private MenuItem menu_exit;
	private SubMenu menu_sub;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
       	setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	super.onCreateOptionsMenu(menu);
    	this.main_menu = menu;
    	
    	
    	menu_sub = menu.addSubMenu("Menu");
    	menu_sub.setIcon(R.drawable.game);
    	
    	
    	menu_hex_team = menu.add("HexTeam");
    	menu_hex_team.setIcon(R.drawable.helmet);
    	
    	menu_exit = menu.add("Wyjście");
    	menu_exit.setIcon(R.drawable.exit);
    	
    	
    	MenuInflater inflater = new MenuInflater(this);
    	inflater.inflate(R.menu.menu, menu_sub);
    	
    	return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
    	
    	AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
    	dialogBuilder.setCancelable(true);
    	
    	if(item.getItemId() == R.id.menu_ustawienia)
    	{
    		dialogBuilder.setMessage("Osobne okno na "+item.getTitle());
    		dialogBuilder.create().show();
    	}
    	else if(item == menu_hex_team){
    		String team = ":\n Anna Warpechowska\n Marcin Koźniewski\n Łukasz Moczulski\n Krzysztof Nowak";
    		dialogBuilder.setMessage(item.getTitle()+team);
    		dialogBuilder.create().show();
    	}
    	else if (item.hasSubMenu() == false)
    	{
    		dialogBuilder.setMessage("Odpala sie "+item.getTitle());
    		dialogBuilder.create().show();
    	}
    	return true;
    }
}