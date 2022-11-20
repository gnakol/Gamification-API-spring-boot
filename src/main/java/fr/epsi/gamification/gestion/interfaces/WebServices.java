package fr.epsi.gamification.gestion.interfaces;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface WebServices<T> {

    public List<T> get_all();

    public void add_one(T e) throws GeneralSecurityException;

    public T update(int id, T e);

    public void remove(int id);

    public T getById(int id);
}
