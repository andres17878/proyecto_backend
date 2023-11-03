package com.example.demo.bean;

public class Admins {
    
        private int id;
        private String nom;
        private String cognom;
        private String curs;
    
        public Admins(int id, String nom, String cognom, String curs) {
            this.id = id;
            this.nom = nom;
            this.cognom = cognom;
            this.curs = curs;
        }
    
        public Admins() {
        }
    
        public int getId() {
            return id;
        }
    
        public String getNom() {
            return nom;
        }
    
        public String getCognom() {
            return cognom;
        }
    
        public String getCurs() {
            return curs;
        }
    
        public void setId(int id) {
            this.id = id;
        }   
    
        public void setNom(String nom) {
            this.nom = nom;
        }   
    
        public void setCognom(String cognom) {
            this.cognom = cognom;
        }   
    
        public void setCurs(String curs) {
            this.curs = curs;
        }
    
        @Override
        public String toString() {
            return "Admins{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", curs=" + curs + '}';
        }
	

}
