### Réponse aux questions

### Question 1

- **Match_parent** : Adapté la taille en fonction du composant parent.
- **Wrap_content** : La taille est adaptée en fonction de la taille nécessaire au composant, donc elle ne prendra que la taille dont le composant a besoin.
- **android**: Définit le sens du conteneur, horizontal ou vertical.
- **android**: Permet de définir le texte affiché dans un bouton, un label, etc.

### Question 2

- **Quel est le package de la classe Button ?**
    - `android.widget`
- **Donnez 5 autres classes de ce package qui vous sont familières, par exemple des classes proches des classes JavaFX :**
    - `TextView`
    - `EditText`
    - `ImageView`
    - `CheckBox`
    - `RadioButton`

### Question 3

- **Dans quelle classe est définie `findViewById` ?**
    - Elle est définie dans la classe `Activity` du package `android.app`, probablement située dans `AppCompatActivity`.
- **Quel est le type de retour de `findViewById` ?**
    - Retourne :
        
        ```
        T findViewById(int id)
        ```
        
        - Une vue avec l'ID donné si elle est trouvée, sinon `null`.
        - Référence :
            
            [Activity  |  Android Developers](https://developer.android.com/reference/android/app/Activity.html#findViewById(int))
            

### Question 4

- **Quel est le type de l'élément `View.OnClickListener` ?**
    - C'est une interface.
- **Dans quel package se trouve cet élément ?**
    - Il se trouve dans le package `android.view.View.OnClickListener`.
    - Référence :
        
        [View.OnClickListener  |  Android Developers](https://developer.android.com/reference/android/view/View.OnClickListener.html)
        

### Question 5

- **Quel est le package de la classe Log ?**
    - Elle est dans le package `android.util.Log`.
    - Référence :
        
        [Log  |  Android Developers](https://developer.android.com/reference/android/util/Log)
        
- **Quelles sont les méthodes disponibles dans la classe `Log` ?**
1. **Assert** (`Log.a`)
2. **Debug** (`Log.d`)
    - Avec 3 paramètres :
        - `String tag`
        - `String msg`
        - `Throwable tr`
    - Avec 2 paramètres :
        - `String tag`
        - `String msg`
3. **Error** (`Log.e`)
4. **Info** (`Log.i`)
5. **Verbose** (`Log.v`)
    - Avec 3 paramètres :
        - `String tag`
        - `String msg`
        - `Throwable tr`
    - Avec 2 paramètres :
        - `String tag`
        - `String msg`
6. **Warn** (`Log.w`)
    - Avec 3 paramètres :
        - `String tag`
        - `String msg`
        - `Throwable tr`
    - Avec 2 paramètres :
        - `String tag`
        - `String msg`
    - Avec 2 autres paramètres :
        - `String tag`
        - `Throwable tr`
7. **getStackTraceString**
    - Retourne la chaîne "trace" d'erreur lorsqu'on reçoit un `Throwable`.
    - **Doc** : Fonction pratique pour obtenir une trace d'exécution loggable depuis un `Throwable`. Si l'une des exceptions dans la chaîne de causes est une `UnknownHostException`, cela retourne une chaîne vide.
8. **isLoggable**
    - Vérifie si un log pour le tag spécifié est loggable au niveau spécifié.
    - **Doc** : La vérification permet de savoir si un message doit être loggé pour un tag donné à un niveau particulier. Le niveau par défaut pour tout tag est défini à INFO, ce qui signifie que tout niveau supérieur ou égal à INFO sera loggé.
        - Commande pour changer le niveau par défaut :
        
        ```
        setprop log.tag.<YOUR_LOG_TAG> <LEVEL>
        Où LEVEL peut être VERBOSE, DEBUG, INFO, WARN, ERROR, ou ASSERT.
        ```
        
9. **println**
    - Avec 3 paramètres :
        - `int priority`
        - `String tag`
        - `String msg`
10. **Log.wtf** (What a Terrible Failure)
- Avec 3 paramètres :
    - `String tag`
    - `String msg`
    - `Throwable tr`
- Avec 2 paramètres :
    - `String tag`
    - `String msg`
- Avec 2 autres paramètres :
    - `String tag`
    - `Throwable tr`

---

## Utilisation de LogCat avec un tag

### Utilisation pratique :

```markdown
tag:Nom du tag dans les logs
```

![Capture d’écran 2024-09-17 à 22.35.49.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/9be4ca09-5965-4a26-a80e-0f294f1cf24b/447c7918-8951-4b82-9e75-df638285c2c0/Capture_decran_2024-09-17_a_22.35.49.png)

### Référence officiel
