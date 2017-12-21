package nyc.c4q.unitfinal.bookrecycler.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.unitfinal.DisplayFragment;
import nyc.c4q.unitfinal.R;
import nyc.c4q.unitfinal.TopFragment;
import nyc.c4q.unitfinal.bookrecycler.model.Book;

/**
 * Created by amirahoxendine on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {
    TextView bookTitle;
    TextView bookAuthor;
    TextView bookYear;
    Activity display;
    Context context;
    String author;
    String title;
    String year;


    public BookViewHolder(final View itemView) {
        super(itemView);
        bookTitle = (TextView) itemView.findViewById(R.id.book_title_textview);
        bookAuthor = (TextView) itemView.findViewById(R.id.book_author_textview);
        bookYear = (TextView) itemView.findViewById(R.id.book_year_textview);
        context = itemView.getContext();


    }
    public void onBind(final Book book){
        title = book.getTitle();
        author = book.getAuthor();
        year = String.valueOf(book.getYear());
        bookTitle.setText(title);
        bookAuthor.setText(author);
        bookYear.setText(year);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DisplayFragment displayFragment = new DisplayFragment();
                TopFragment topFragment = (TopFragment) ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(R.id.top_fragment_container_framelayout);


                //FragmentManager fragmentManager =((FragmentActivity) context).getSupportFragmentManager();
                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("author", author);
                bundle.putString("title", title);
                bundle.putString("year", year);
                topFragment.updateView(bundle);



            }
        });

    }
}
