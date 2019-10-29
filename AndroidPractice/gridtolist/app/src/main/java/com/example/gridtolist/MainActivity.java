 package com.example.gridtolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static com.example.gridtolist.itemAdapter.SPAN_COUNT_THREE;
import static com.example.gridtolist.itemAdapter.SPAN_COUNT_ONE;


 public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private itemAdapter itemAdapter;
     private GridLayoutManager gridLayoutManager;
     private List<item> items;
     ImageView h;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
         initItemData();

         gridLayoutManager=new GridLayoutManager(this,SPAN_COUNT_ONE);
         itemAdapter=new itemAdapter(items,gridLayoutManager);
         recyclerView=(RecyclerView)findViewById(R.id.rv);
         recyclerView.setAdapter(itemAdapter);
         recyclerView.setLayoutManager(gridLayoutManager);

         h=findViewById(R.id.tog);
         h.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 switchImage();
                 switchLayout();
             }
         });
     }



     private void initItemData() {
         items = new ArrayList<>(15);
         items.add(new item(R.drawable.cbin, "Bin #1","Slottedscrews", "20%"));
         items.add(new item(R.drawable.cbin, "Bin #2", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #3", "Slottedscrews", "10%"));
         items.add(new item(R.drawable.cbin, "Bin #4", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #5","Slottedscrews", "40%"));
         items.add(new item(R.drawable.cbin, "Bin #6", "Slottedscrews", "40%"));
         items.add(new item(R.drawable.cbin, "Bin #7", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #8", "Slottedscrews", "20%"));
         items.add(new item(R.drawable.cbin, "Bin #9","Slottedscrews", "20%"));
         items.add(new item(R.drawable.cbin, "Bin #10", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #11", "Slottedscrews", "10%"));
         items.add(new item(R.drawable.cbin, "Bin #12", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #13", "Slottedscrews", "40%"));
         items.add(new item(R.drawable.cbin, "Bin #14", "Slottedscrews", "30%"));
         items.add(new item(R.drawable.cbin, "Bin #15", "Slottedscrews", "30%"));
     }

     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main, menu);
         return true;
     }



     public boolean onOptionsItemSelected(MenuItem item) {
         if (item.getItemId() == R.id.menu_switch_layout) {
             switchLayout();
             switchIcon(item);
             return true;
         }
         return super.onOptionsItemSelected(item);
     }


     private void switchLayout() {
         if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
             gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
         } else {
             gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
         }
         itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
     }

     private void switchIcon(MenuItem item){
         if(gridLayoutManager.getSpanCount()==SPAN_COUNT_THREE){
             item.setIcon(getResources().getDrawable(R.drawable.ic_span_1));
         }else{
             item.setIcon(getResources().getDrawable(R.drawable.ic_span_3));
         }
     }

     void switchImage(){
         if(gridLayoutManager.getSpanCount()==SPAN_COUNT_THREE){
             h.setImageResource(R.drawable.ic_span_1);
         }else{
             h.setImageResource(R.drawable.ic_span_3);
         }
     }
}
