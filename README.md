Documentation sur les Tests, JUnit, Tests Doubles et Mockito : 

--JUnit : est un framework de test unitaire populaire pour les applications Java. Il permet de définir des cas de test, d'exécuter ces cas de test et de générer des rapports sur les résultats. 

Voici un exemple de code JUnit :

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyTest {
    @Test
    public void testAddition() {
        int result = Calculator.add(2, 3);
        assertEquals(5, result);
    }
}

--Tests Doubles : Les tests doubles sont des objets utilisés pour simuler des composants réels dans les tests. Ils sont utilisés pour isoler le code en testant en remplaçant les dépendances externes. Les types de tests doubles courants incluent les "stubs" (simulateurs), les "spies" (observateurs) et les "mocks" (simulacres).

--Mockito : est un framework de création de mock pour Java. Il permet de créer des objets mock pour remplacer les dépendances réelles lors de la réalisation de tests. 

Voici un exemple de code utilisant Mockito :

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

MyService service = Mockito.mock(MyService.class);

when(service.doSomething()).thenReturn("Résultat simulé");

assertEquals("Résultat simulé", service.doSomething());
