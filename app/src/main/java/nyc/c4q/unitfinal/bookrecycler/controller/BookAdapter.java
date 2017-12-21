package nyc.c4q.unitfinal.bookrecycler.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.unitfinal.R;
import nyc.c4q.unitfinal.bookrecycler.model.Book;
import nyc.c4q.unitfinal.bookrecycler.view.BookViewHolder;

/**
 * Created by amirahoxendine on 12/20/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {
    List<Book> booklist;

    public BookAdapter(List<Book> booklist){
        this.booklist = booklist;
    }
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_view, parent, false);
        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
    Book book = booklist.get(position);
    holder.onBind(book);
    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }
}
