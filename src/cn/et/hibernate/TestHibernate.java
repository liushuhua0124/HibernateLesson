package cn.et.hibernate;

import org.hibernate.Session;

import cn.et.hibernate.dao.Food;

public class TestHibernate {
	public static void main(String[] args) {
		queryFood();
	}
	
	public static void saveFood() {
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodname("Æ»¹ûÉ³À­");
		food.setImagepath("/a");
		food.setPrice(10.0);
		session.getTransaction().begin();
		session.save(food);
		session.getTransaction().commit();
	}
	
	public static void deleteFood() {
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodid(27);
		session.getTransaction().begin();
		session.delete(food);
		session.getTransaction().commit();
	}
	
	public static void queryFood() {
		Session session = HibernateSessionFactory.getSession();
		Food load = (Food) session.load(Food.class, 19);
		System.out.println(load.getFoodname());
	}
}
