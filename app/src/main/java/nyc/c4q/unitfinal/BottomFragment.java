package nyc.c4q.unitfinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unitfinal.bookrecycler.controller.BookAdapter;
import nyc.c4q.unitfinal.bookrecycler.model.Book;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    View rootView;
    RecyclerView recyclerView;
    String jsonString;
    List<Book> bookList;

    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_bottom, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.bottom_fragment_recyclerview);
        bookList = setBookList();
        BookAdapter bookAdapter = new BookAdapter(bookList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bookAdapter);
        return rootView;
    }

    public List<Book> setBookList(){
        List<Book> bookList = new ArrayList<>();
        JSONObject bookJsonObject = setJson(getJsonString());
        JSONArray bookJsonArray = null;
        try {
            bookJsonArray = bookJsonObject.getJSONArray("books");
            for (int i =0; i< bookJsonArray.length(); i++) {
                JSONObject jsonArrayObject = (JSONObject) bookJsonArray.get(i);
                Book book = new Book();
                String bookTitle= jsonArrayObject.getString("title");
                String bookAuthor = jsonArrayObject.getString("author");
                int bookYear = jsonArrayObject.getInt("year");
                book.setAuthor(bookAuthor);
                book.setTitle(bookTitle);
                book.setYear(bookYear);
                bookList.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookList;
    }
    public JSONObject setJson(String jsonString){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {

        }
        return jsonObject;
    }

    public String getJsonString(){
        jsonString = "{  \n" +
                "   \"books\":[  \n" +
                "      {  \n" +
                "         \"title\":\"Northanger Abbey\",\n" +
                "         \"author\":\"Austen, Jane\",\n" +
                "         \"year\":1814\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"War and Peace\",\n" +
                "         \"author\":\"Tolstoy, Leo\",\n" +
                "         \"year\":1865\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"Anna Karenina\",\n" +
                "         \"author\":\"Tolstoy, Leo\",\n" +
                "         \"year\":1875\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"Mrs. Dalloway\",\n" +
                "         \"author\":\"Woolf, Virginia\",\n" +
                "         \"year\":1925\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"The Hours\",\n" +
                "         \"author\":\"Cunnningham, Michael\",\n" +
                "         \"year\":1999\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"Huckleberry Finn\",\n" +
                "         \"author\":\"Twain, Mark\",\n" +
                "         \"year\":1865\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"Bleak House\",\n" +
                "         \"author\":\"Dickens, Charles\",\n" +
                "         \"year\":1870\n" +
                "      },\n" +
                "      {  \n" +
                "         \"title\":\"Tom Sawyer\",\n" +
                "         \"author\":\"Twain, Mark\",\n" +
                "         \"year\":1862\n" +
                "      }\n" +
                "   ]\n" +
                "}";
        return jsonString;
    }


}
