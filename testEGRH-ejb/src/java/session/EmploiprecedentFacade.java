/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Emploiprecedent;
import bean.Employe;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sara
 */
@Stateless
@LocalBean
public class EmploiprecedentFacade extends AbstractFacade<Emploiprecedent> implements EmploiprecedentFacadeLocal {
    @PersistenceContext(unitName = "testEGRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmploiprecedentFacade() {
        super(Emploiprecedent.class);
    }
    @Override
     public Employe getEmployesById(Emploiprecedent emp){
        Query query = em.createQuery( "SELECT e FROM Employe e WHERE e.id ="+emp.getEmploye().getId() );
        
        return   (Employe) query.getSingleResult();
     }
}
