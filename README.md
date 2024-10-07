# Réponse aux questions


## Laboratoire 1

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


# Laboratoire 2 

## Question 1 

### 1. Lancement de l'application

Lorsqu'on lance l'application, les méthodes suivantes sont appelées :

- `onCreate()` : La méthode `onCreate()` est appelée une seule fois lorsque l'activité est créée.
- `onStart()` : L'activité devient visible à l'utilisateur.
- `onResume()` : L'activité est maintenant au premier plan, et l'utilisateur peut interagir avec elle.

**Méthodes appelées :**

- `onCreate()`
- `onStart()`
- `onResume()`

---

### 2. Quitter l'application (bouton Back après l'avoir lancée)

Lorsque tu quittes l'application en appuyant sur le bouton "Retour" (Back), l'activité est détruite. Les méthodes suivantes sont appelées :

- `onPause()` : L'activité n'est plus au premier plan.
- `onStop()` : L'activité n'est plus visible.
- `onDestroy()` : L'activité est détruite.

**Méthodes appelées :**

- `onPause()`
- `onStop()`
- `onDestroy()`

---

### 3. Changer d'application (avec le task manager)

Lorsque tu changes d'application via le gestionnaire de tâches, l'activité passe en arrière-plan, mais elle n'est pas détruite. Les méthodes suivantes sont appelées :

- `onPause()` : L'activité n'est plus au premier plan.
- `onStop()` : L'activité n'est plus visible, mais elle reste en mémoire.

**Méthodes appelées :**

- `onPause()`
- `onStop()`

---

### 4. Revenir à l'application (avec le task manager)

Lorsque tu reviens à l'application après l'avoir mise en arrière-plan, les méthodes suivantes sont appelées :

- `onRestart()` : Appelée lorsque l'activité est arrêtée et va être relancée.
- `onStart()` : L'activité devient visible à nouveau.
- `onResume()` : L'activité est à nouveau au premier plan et prête à interagir avec l'utilisateur.

**Méthodes appelées :**

- `onRestart()`
- `onStart()`
- `onResume()`

---

### 5. Rotation de l'appareil

Lorsque tu effectues une rotation de l'appareil, Android détruit et recrée l'activité par défaut (sauf si tu as spécifié un comportement personnalisé). Les méthodes suivantes sont appelées :

- `onPause()` : L'activité est en train de quitter le premier plan.
- `onStop()` : L'activité n'est plus visible.
- `onDestroy()` : L'activité est détruite.
- `onCreate()` : Une nouvelle instance de l'activité est créée.
- `onStart()` : L'activité devient visible à nouveau.
- `onResume()` : L'activité est à nouveau au premier plan.

**Méthodes appelées :**

- `onPause()`
- `onStop()`
- `onDestroy()`
- `onCreate()`
- `onStart()`
- `onResume()`

## Question 2 :

## Types d'éléments que l'on peut enregistrer dans un Bundle

### Types primitifs

Les types primitifs sont directement supportés par le `Bundle`. Voici une liste des types primitifs et leurs méthodes associées :

- `int` : `putInt()`, `getInt()`
- `long` : `putLong()`, `getLong()`
- `boolean` : `putBoolean()`, `getBoolean()`
- `double` : `putDouble()`, `getDouble()`
- `float` : `putFloat()`, `getFloat()`
- `char` : `putChar()`, `getChar()`
- `byte` : `putByte()`, `getByte()`

### Chaînes de caractères et tableaux

- `String` : `putString()`, `getString()`
- Tableaux de types primitifs : `putIntArray()`, `putFloatArray()`, etc.

### Objets `Parcelable`

Android supporte également des objets qui implémentent l'interface `Parcelable`. Cela permet de sérialiser des objets complexes et de les passer via un `Bundle`. Par exemple :

- `putParcelable()`, `getParcelable()`
- Pour une liste d'objets : `putParcelableArrayList()`, `getParcelableArrayList()`

### Objets `Serializable`

Les objets qui implémentent l'interface `Serializable` peuvent également être enregistrés dans un `Bundle`, mais l'utilisation de `Parcelable` est souvent préférée pour des raisons de performance. Méthodes :

- `putSerializable()`, `getSerializable()`

### Types spécifiques Android

- `Bundle` : Un autre `Bundle` peut être imbriqué dans un `Bundle`. Méthodes : `putBundle()`, `getBundle()`
- `SparseArray` : Type spécifique à Android pour des collections optimisées. Méthodes : `putSparseParcelableArray()`
- `CharSequence` : `putCharSequence()`, `getCharSequence()`
- `IBinder` : `putBinder()`, `getBinder()` (pour des services liés)

## Réponse à la question 3 : Où est définie la méthode `getString(int)` ?

La méthode `getString(int)` est définie dans la classe `Context`, qui est une classe de base en Android. Comme toutes les `Activity` héritent de `Context`, vous pouvez l'utiliser directement dans une activité pour récupérer une chaîne de caractères à partir des ressources.
