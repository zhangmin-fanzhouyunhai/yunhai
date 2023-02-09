package com.yunhai.excel.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.yunhai.excel.orm.CtBreakdown;

/**
 * A data access object (DAO) providing persistence and search support for
 * CtBreakdown entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yunhai.excel.orm.virtualdell.zcxz.submitData.orm.CtBreakdown
 * @author MyEclipse Persistence Tools
 */
@Transactional
@SuppressWarnings("rawtypes")
public class CtBreakdownDAO {
	private static final Logger log = LoggerFactory.getLogger(CtBreakdownDAO.class);
	// property constants
	public static final String ORG_NAME = "orgName";
	public static final String YEAR = "year";
	public static final String ZC_DL = "zcDl";
	public static final String ZC_ZL = "zcZl";
	public static final String ZC_XL = "zcXl";
	public static final String ERP_CODE = "erpCode";
	public static final String VOLTAGE_LEVEL = "voltageLevel";
	public static final String Y2004 = "y2004";
	public static final String Y2005 = "y2005";
	public static final String Y2006 = "y2006";
	public static final String Y2007 = "y2007";
	public static final String Y2008 = "y2008";
	public static final String Y2009 = "y2009";
	public static final String Y2010 = "y2010";
	public static final String Y2011 = "y2011";
	public static final String Y2012 = "y2012";
	public static final String Y2013 = "y2013";
	public static final String Y2014 = "y2014";
	public static final String Y2015 = "y2015";
	public static final String QUANTITY = "quantity";
	public static final String NON_PLAN_QUANTITY = "nonPlanQuantity";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(CtBreakdown transientInstance) {
		log.debug("saving CtBreakdown instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CtBreakdown persistentInstance) {
		log.debug("deleting CtBreakdown instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CtBreakdown findById(java.lang.String id) {
		log.debug("getting CtBreakdown instance with id: " + id);
		try {
			CtBreakdown instance = (CtBreakdown) getCurrentSession().get("com.virtualdell.zcxz.submitData.orm.CtBreakdown", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CtBreakdown instance) {
		log.debug("finding CtBreakdown instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.virtualdell.zcxz.submitData.orm.CtBreakdown")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CtBreakdown instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CtBreakdown as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrgName(Object orgName) {
		return findByProperty(ORG_NAME, orgName);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByZcDl(Object zcDl) {
		return findByProperty(ZC_DL, zcDl);
	}

	public List findByZcZl(Object zcZl) {
		return findByProperty(ZC_ZL, zcZl);
	}

	public List findByZcXl(Object zcXl) {
		return findByProperty(ZC_XL, zcXl);
	}

	public List findByErpCode(Object erpCode) {
		return findByProperty(ERP_CODE, erpCode);
	}

	public List findByVoltageLevel(Object voltageLevel) {
		return findByProperty(VOLTAGE_LEVEL, voltageLevel);
	}

	public List findByY2004(Object y2004) {
		return findByProperty(Y2004, y2004);
	}

	public List findByY2005(Object y2005) {
		return findByProperty(Y2005, y2005);
	}

	public List findByY2006(Object y2006) {
		return findByProperty(Y2006, y2006);
	}

	public List findByY2007(Object y2007) {
		return findByProperty(Y2007, y2007);
	}

	public List findByY2008(Object y2008) {
		return findByProperty(Y2008, y2008);
	}

	public List findByY2009(Object y2009) {
		return findByProperty(Y2009, y2009);
	}

	public List findByY2010(Object y2010) {
		return findByProperty(Y2010, y2010);
	}

	public List findByY2011(Object y2011) {
		return findByProperty(Y2011, y2011);
	}

	public List findByY2012(Object y2012) {
		return findByProperty(Y2012, y2012);
	}

	public List findByY2013(Object y2013) {
		return findByProperty(Y2013, y2013);
	}

	public List findByY2014(Object y2014) {
		return findByProperty(Y2014, y2014);
	}

	public List findByY2015(Object y2015) {
		return findByProperty(Y2015, y2015);
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByNonPlanQuantity(Object nonPlanQuantity) {
		return findByProperty(NON_PLAN_QUANTITY, nonPlanQuantity);
	}

	public List findAll() {
		log.debug("finding all CtBreakdown instances");
		try {
			String queryString = "from CtBreakdown";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CtBreakdown merge(CtBreakdown detachedInstance) {
		log.debug("merging CtBreakdown instance");
		try {
			CtBreakdown result = (CtBreakdown) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CtBreakdown instance) {
		log.debug("attaching dirty CtBreakdown instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CtBreakdown instance) {
		log.debug("attaching clean CtBreakdown instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CtBreakdownDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CtBreakdownDAO) ctx.getBean("CtBreakdownDAO");
	}
}