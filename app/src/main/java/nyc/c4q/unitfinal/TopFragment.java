package nyc.c4q.unitfinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    View rootView;
    TextView bookTitle;
    TextView bookAuthor;
    TextView bookYear;

    String author;
    String title;
    String year;
    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =  inflater.inflate(R.layout.fragment_top, container, false);
        bookTitle = (TextView) rootView.findViewById(R.id.topfrag_book_title__textview);
        bookAuthor = (TextView) rootView.findViewById(R.id.topfrag_book_author_textview);
        bookYear = (TextView) rootView.findViewById(R.id.topfrag_book_year_textview);

        return rootView;
    }
    public void updateView(Bundle bundle){

        author = bundle.getString("author");
        title = bundle.getString("title");
        year = bundle.getString("year");
        bookAuthor.setText(author);
        bookTitle.setText(title);
        bookYear.setText(year);


    }

}
