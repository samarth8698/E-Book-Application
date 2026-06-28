package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;
import com.entity.Category;
import com.entity.Feedback;

public class BookDAOImpl implements BookDAO
{
    private Connection conn;

    public BookDAOImpl(Connection conn)
    {
        this.conn = conn;
    }
    
    // Add a new book
    public boolean addBooks(BookDtls b)
    {
        boolean f = false;
        try
        {
            String sql = "INSERT INTO book_dtls(bookname, author, price, bookCategory, status, photo, email, isbn) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBookName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPrice());
            ps.setString(4, b.getBookCategory());
            ps.setString(5, b.getStatus());
            ps.setString(6, b.getPhotoName());
            ps.setString(7, b.getEmail());
            ps.setString(8, b.getIsbn());
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return f;
    }
    
    // Get all books
    public List<BookDtls> getAllBooks() 
    {
        List<BookDtls> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM book_dtls";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return list;
    }
    
    // Get book by ID
    public BookDtls getBookById(int id)
    {
        BookDtls b = null;
        try 
        {
            String sql = "SELECT * FROM book_dtls WHERE bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                b = mapResultSetToBook(rs);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return b;
    }
    
    // Update book
    public boolean updateEditBooks(BookDtls b) 
    {
        boolean f = false;
        try
        {
            String sql = "UPDATE book_dtls SET bookname=?, author=?, price=?, bookCategory=?, status=?, isbn=? WHERE bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBookName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPrice());
            ps.setString(4, b.getBookCategory());
            ps.setString(5, b.getStatus());
            ps.setString(6, b.getIsbn());
            ps.setInt(7, b.getBookId());
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        } 
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return f;
    }

    // Delete book by ID
    public boolean deleteBooks(int id) 
    {
        boolean f = false;
        try
        {
            String sql = "DELETE FROM book_dtls WHERE bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return f;
    }

    // Get new books (first 4)
    public List<BookDtls> getNewBook() 
    {
        List<BookDtls> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM book_dtls WHERE bookCategory=? AND status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "New");
            ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next() && i < 4)
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
                i++;
            }
        } 
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get recent books
    public List<BookDtls> getRecentBooks()
    {
        List<BookDtls> list = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM book_dtls WHERE status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get old books (first 4)
    public List<BookDtls> getOldBooks()
    {
        List<BookDtls> list = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM book_dtls WHERE bookCategory=? AND status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Old");
            ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next() && i < 4) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
                i++;
            }
        } 
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get all recent books
    public List<BookDtls> getAllRecentBook() 
    {
        List<BookDtls> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM book_dtls WHERE status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get all new books by category
    public List<BookDtls> getAllNewBook(String cat) 
    {
        List<BookDtls> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM book_dtls WHERE bookCategory=? AND status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cat);
            ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get all old books
    public List<BookDtls> getAllOldBook() 
    {
        List<BookDtls> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM book_dtls WHERE bookCategory=? AND status=? ORDER BY bookId DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Old");
            ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get books by user email and category
    public List<BookDtls> getBookByOld(String email, String cate) 
    {
        List<BookDtls> list = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM book_dtls WHERE bookCategory=? AND email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cate);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Delete old book by email, category, and ID
    public boolean oldBookDelete(String email, String cat, int id) 
    {
        boolean f = false;
        try 
        {
            String sql = "DELETE FROM book_dtls WHERE bookCategory=? AND email=? AND bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cat);
            ps.setString(2, email);
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        } 
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return f;
    }

    // Search books
    public List<BookDtls> getBookBySerch(String ch) 
    {
        List<BookDtls> list = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM book_dtls WHERE (bookname LIKE ? OR author LIKE ? OR bookCategory LIKE ?) AND status=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ch + "%");
            ps.setString(2, "%" + ch + "%");
            ps.setString(3, "%" + ch + "%");
            ps.setString(4, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                BookDtls b = mapResultSetToBook(rs);
                list.add(b);
            }
        }
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Add a category
    public boolean addCategory(String categoryName)
    {
        boolean f = false;
        try
        {
            String sql = "INSERT INTO category(name) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoryName);
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        } 
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return f;
    }

    // Get all categories
    public List<Category> getAllCategory()
    {
        List<Category> list = new ArrayList<>();
        try 
        {
            String sql = "SELECT * FROM category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                Category ca = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(ca);
            }
        } 
        catch (Exception e) 
        {
        	System.out.println(e);
        }
        return list;
    }

    // Get all feedback for a book
    public List<Feedback> getAllFeedbackByBook(int bookId)
    {
        List<Feedback> list = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM feedback WHERE bookId=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                Feedback f = new Feedback(rs.getInt("id"), rs.getInt("bookId"), rs.getInt("rating"), rs.getString("feedback"));
                list.add(f);
            }
        } 
        catch (Exception e)
        {
        	System.out.println(e);
        }
        return list;
    }

    // Utility: map ResultSet to BookDtls
    private BookDtls mapResultSetToBook(ResultSet rs) throws Exception
    {
        BookDtls b = new BookDtls();
        b.setBookId(rs.getInt("bookId"));
        b.setBookName(rs.getString("bookname"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getString("price"));
        b.setBookCategory(rs.getString("bookCategory"));
        b.setStatus(rs.getString("status"));
        b.setPhotoName(rs.getString("photo"));
        b.setEmail(rs.getString("email"));
        b.setIsbn(rs.getString("isbn"));
        return b;
    }
}
