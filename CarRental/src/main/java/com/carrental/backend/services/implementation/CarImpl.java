package com.carrental.backend.services.implementation;

import com.carrental.backend.form.CarForm;
import com.carrental.backend.model.Car;
import com.carrental.backend.repository.CarRepository;
import com.carrental.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import java.util.List;

@Service("carService")
@Transactional
public class CarImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Car> getAvailableCarList() {
        return carRepository.getCarByAvailability(true);
    }

    @Override
    public List<Car> getCarListByFilter(CarForm form) {
        String brandName = form.getBrandName();
        String modelName = form.getModelName();
        double maxPrice = form.getMaxPrice();
        double condition = form.getCondition();
        int yearFrom = form.getYearFrom();
        String sort = form.getSort();

        EntityManager em = this.entityManager;

        //get class name
        Class<?> c1 = Car.class;
        Table table = c1.getAnnotation(Table.class);
        String carTable = table.name();

        String filterQuery = "car.isAvailable = 1 "; // default filter
        String brandFilter = "";
        String modelFilter = "";
        String yearFilter = "";
        String priceFilter = "";
        String conditionFilter = "";

        if(brandName!=null && !brandName.equalsIgnoreCase("")){
            brandFilter = "lower(car.brandName) like lower(:brandName) ";
            filterQuery = filterQuery + "and " + brandFilter;
        }
        if(modelName!=null && !modelName.equalsIgnoreCase("")){
            modelFilter = "lower(car.modelName) like lower(:modelName) ";
            filterQuery = filterQuery + "and " + modelFilter;
        }
        if(yearFrom > -1){
            yearFilter = "car.year <= :yearFrom ";
            filterQuery = filterQuery + "and " + yearFilter;
        }
        if(maxPrice > -1){
            priceFilter = "car.price <= :maxPrice ";
            filterQuery = filterQuery + "and " + priceFilter;
        }
        if(condition > -1){
            conditionFilter = "car.condition >= :condition ";
            filterQuery = filterQuery + "and " + conditionFilter;
        }


        String orderQuery = "order by car.id";
        String orderQueryBrandNameASC = "order by car.brandName ASC, car.id ASC ";
        String orderQueryBrandNameDESC = "order by car.brandName DESC, car.id ASC ";
        String orderQueryModelNameASC = "order by car.modelName ASC, car.id ASC ";
        String orderQueryModelNameDESC = "order by car.modelName DESC, car.id ASC ";
        String orderQueryYearASC = "order by car.year ASC, car.id ASC ";
        String orderQueryYearDESC = "order by car.year DESC, car.id ASC ";
        String orderQueryPriceASC = "order by car.price ASC, car.id ASC ";
        String orderQueryPriceDESC = "order by car.price DESC, car.id ASC ";
        String orderQueryConditionASC = "order by car.condition ASC, car.id ASC ";
        String orderQueryConditionDESC = "order by car.condition DESC, car.id ASC ";

        if(sort.equalsIgnoreCase("0")){
            orderQuery = orderQuery;
        } else if(sort.equalsIgnoreCase("branda")) {
            orderQuery = orderQueryBrandNameASC;
        } else if(sort.equalsIgnoreCase("brandz")) {
            orderQuery = orderQueryBrandNameDESC;
        } else if(sort.equalsIgnoreCase("modela")) {
            orderQuery = orderQueryModelNameASC;
        } else if(sort.equalsIgnoreCase("modelz")) {
            orderQuery = orderQueryModelNameDESC;
        } else if(sort.equalsIgnoreCase("old")) {
            orderQuery = orderQueryYearASC;
        } else if(sort.equalsIgnoreCase("new")) {
            orderQuery = orderQueryYearDESC;
        } else if(sort.equalsIgnoreCase("pricea")) {
            orderQuery = orderQueryPriceASC;
        } else if(sort.equalsIgnoreCase("priced")) {
            orderQuery = orderQueryPriceDESC;
        } else if(sort.equalsIgnoreCase("cona")) {
            orderQuery = orderQueryConditionASC;
        } else if(sort.equalsIgnoreCase("cond")) {
            orderQuery = orderQueryConditionDESC;
        }

        Query query = em.createNativeQuery("select * from " + carTable + " car "
                + "where " + filterQuery + orderQuery
        );

        if(!brandFilter.equalsIgnoreCase("")) {
            query.setParameter("brandName", brandName);
        }
        if(!modelFilter.equalsIgnoreCase("")) {
            query.setParameter("modelName", modelName);
        }
        if(!yearFilter.equalsIgnoreCase("")) {
            query.setParameter("yearFrom", yearFrom);
        }
        if(!conditionFilter.equalsIgnoreCase("")) {
            query.setParameter("condition", condition);
        }
        if(!priceFilter.equalsIgnoreCase("")) {
            query.setParameter("maxPrice", maxPrice);
        }

        List<Car> carList = query.getResultList();

        em.close();

        System.out.println("CARLISTSIZE = " + carList.size());
        if(carList!=null && carList.size() > 0) {
            return carList;
        }

        return null;
    }
}
