package be.com.learn.adminsys.laboratoire1.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import be.com.learn.adminsys.laboratoire1.R;

public class Quiz {
    private Question[] mQuestionBank;
    private int mCurrentIndex;
    private int mCurrentQuestion;
    private int mCurrentScore;
    private int[] mChosenQuestion = new int[10];

    public Quiz() {
        this.mCurrentIndex = 0;
        this.setQuestionBank();
        this.mCurrentScore = 0;
    }

    //function for the scoreboard
    public void addPoint(){
        mCurrentScore++;
    }
    public int getCurrentScore(){
        return mCurrentScore;
    }
    public void nextQuestion(){
        mCurrentIndex++;
        mCurrentQuestion=mChosenQuestion[mCurrentIndex];
    }
    public int getProgress(){
        return mCurrentIndex;
    }
    public Boolean isLastQuestion(){
        return mCurrentIndex == mChosenQuestion.length-1;
    }
    public boolean isBeforeLastQuestion(){
        return mCurrentIndex == mChosenQuestion.length-2;
    }
    public int getCurrentQuestion(){
        return mQuestionBank[mCurrentQuestion].getTextResId();
    }
    public int getCurrentExplanation(){
        return mQuestionBank[mCurrentQuestion].getExplication();
    }
    public Boolean isCurrentAnswerTrue(){
        return mQuestionBank[mCurrentQuestion].isAnswerTrue();
    }
    public void reStartQuiz() {
        // Réinitialiser le tableau
        mChosenQuestion = new int[mChosenQuestion.length];

        Random rand = new Random();

        // Listes pour séparer les questions vraies et fausses
        List<Question> trueQuestions = new ArrayList<>();
        List<Question> falseQuestions = new ArrayList<>();

        // Remplir les listes avec les questions vraies et fausses
        for (Question q : mQuestionBank) {
            if (q.isAnswerTrue()) {
                trueQuestions.add(q);
            } else {
                falseQuestions.add(q);
            }
        }

        // Générer un pourcentage aléatoire entre 30 et 70 pour les questions vraies
        int truePercentage = rand.nextInt(41) + 30; // Génère un pourcentage entre 30 et 70
        int numTrueQuestions = (mChosenQuestion.length * truePercentage) / 100;
        int numFalseQuestions = mChosenQuestion.length - numTrueQuestions;

        // Mélanger les listes pour obtenir des questions aléatoires
        Collections.shuffle(trueQuestions);
        Collections.shuffle(falseQuestions);

        // Sélectionner le bon nombre de questions vraies et fausses
        List<Question> selectedQuestions = new ArrayList<>();

        // Ajouter les questions vraies
        for (int i = 0; i < numTrueQuestions && i < trueQuestions.size(); i++) {
            selectedQuestions.add(trueQuestions.get(i));
        }

        // Ajouter les questions fausses
        for (int i = 0; i < numFalseQuestions && i < falseQuestions.size(); i++) {
            selectedQuestions.add(falseQuestions.get(i));
        }

        // Mélanger les questions finales sélectionnées
        Collections.shuffle(selectedQuestions);

        // Remplir le tableau mChosenQuestion avec les indices des questions sélectionnées
        for (int i = 0; i < selectedQuestions.size(); i++) {
            mChosenQuestion[i] = Arrays.asList(mQuestionBank).indexOf(selectedQuestions.get(i));
        }

        // Réinitialiser l'index des questions et la question courante
        mCurrentIndex = 0;
        mCurrentScore=0;
        mCurrentQuestion = mChosenQuestion[mCurrentIndex];
    }


    private void setQuestionBank() {
        mQuestionBank = new Question[] {
                new Question(true, R.string.question_australia, R.string.explanation_australia), // Canberra est la capitale de l'Australie.
                new Question(true, R.string.question_oceans, R.string.explanation_oceans), // L'océan Pacifique est plus large que l'océan Atlantique.
                new Question(false, R.string.question_mideast, R.string.explanation_mideast), // Le canal de Suez relie la mer Rouge et l'océan Indien.
                new Question(true, R.string.question_africa, R.string.explanation_africa), // L'Égypte est située en Afrique du Sud.
                new Question(false, R.string.question_asia, R.string.explanation_asia), // Le Japon est composé de plus de 6 000 îles.
                new Question(true, R.string.question_europe, R.string.explanation_europe), // La France est le plus grand pays d'Europe par superficie.
                new Question(true, R.string.question_moon, R.string.explanation_moon), // L'homme a marché sur la Lune en 1969.
                new Question(false, R.string.question_mars, R.string.explanation_mars), // Mars est plus proche du Soleil que la Terre.
                new Question(false, R.string.question_pyramids, R.string.explanation_pyramids), // Les pyramides de Gizeh ont été construites par des esclaves.
                new Question(true, R.string.question_flight, R.string.explanation_flight), // Les frères Wright ont inventé le premier avion fonctionnel.
                new Question(false, R.string.question_internet, R.string.explanation_internet), // L'Internet a été inventé dans les années 1980.
                new Question(true, R.string.question_brazil, R.string.explanation_brazil), // Le Brésil est le plus grand pays d'Amérique du Sud.
                new Question(false, R.string.question_europe, R.string.explanation_europe), // La France est le plus grand pays d'Europe par superficie.
                new Question(true, R.string.question_sahara, R.string.explanation_sahara), // Le Sahara est le plus grand désert du monde.
                new Question(true, R.string.question_amazon, R.string.explanation_amazon), // L'Amazonie est la plus grande forêt tropicale du monde.
                new Question(false, R.string.question_usa, R.string.explanation_usa), // Les États-Unis ont 52 États.
                new Question(false, R.string.question_china, R.string.explanation_china), // La Grande Muraille de Chine est visible depuis l'espace.
                new Question(true, R.string.question_water, R.string.explanation_water), // L'eau couvre environ 71% de la surface de la Terre.
                new Question(true, R.string.question_venus, R.string.explanation_venus), // Vénus est la planète la plus chaude du système solaire.
                new Question(true, R.string.question_russia, R.string.explanation_russia), // La Russie est le plus grand pays du monde.
                new Question(true, R.string.question_nile, R.string.explanation_nile), // Le Nil est le plus long fleuve du monde.
                new Question(true, R.string.question_everest, R.string.explanation_everest), // L'Everest est la plus haute montagne du monde.
                new Question(true, R.string.question_dna, R.string.explanation_dna), // L'ADN humain contient environ 3 milliards de paires de bases.
                new Question(false, R.string.question_electricity, R.string.explanation_electricity), // Thomas Edison a inventé l'électricité.
                new Question(true, R.string.question_dinosaurs, R.string.explanation_dinosaurs), // Les dinosaures ont disparu il y a environ 65 millions d'années.
                new Question(true, R.string.question_ww2, R.string.explanation_ww2), // La Seconde Guerre mondiale a pris fin en 1945.
                new Question(true, R.string.question_rome, R.string.explanation_rome), // Rome a été fondée en 753 avant J.-C.
                new Question(true, R.string.question_gravity, R.string.explanation_gravity), // La gravité sur la Lune est six fois plus faible que sur Terre.
                new Question(false, R.string.question_pluto, R.string.explanation_pluto), // Pluton est toujours considérée comme une planète.
                new Question(true, R.string.question_spain, R.string.explanation_spain), // Madrid est la capitale de l'Espagne.
                new Question(true, R.string.question_sun, R.string.explanation_sun), // Le Soleil est une étoile de type naine jaune.
                new Question(true, R.string.question_mercury, R.string.explanation_mercury), // Mercure est la planète la plus proche du Soleil.
                new Question(true, R.string.question_antarctica, R.string.explanation_antarctica), // L'Antarctique est le continent le plus froid de la Terre.
                new Question(true, R.string.question_galileo, R.string.explanation_galileo), // Galilée a été le premier à observer les lunes de Jupiter.
                new Question(true, R.string.question_alaska, R.string.explanation_alaska), // L'Alaska est l'État le plus au nord des États-Unis.
                new Question(true, R.string.question_einstein, R.string.explanation_einstein), // La théorie de la relativité a été développée par Albert Einstein.
                new Question(true, R.string.question_washington, R.string.explanation_washington), // Washington D.C. est la capitale des États-Unis.
                new Question(true, R.string.question_oil, R.string.explanation_oil), // Le pétrole est la source d'énergie la plus utilisée dans le monde.
                new Question(true, R.string.question_ozone, R.string.explanation_ozone), // La couche d'ozone protège la Terre des rayons UV du Soleil.
                new Question(true, R.string.question_coldwar, R.string.explanation_coldwar), // La guerre froide a opposé les États-Unis et l'Union soviétique.
                new Question(true, R.string.question_vikings, R.string.explanation_vikings), // Les Vikings étaient des explorateurs venus de Scandinavie.
                new Question(true, R.string.question_cows, R.string.explanation_cows), // Les vaches ont quatre estomacs.
                new Question(false, R.string.question_blood, R.string.explanation_blood), // Le groupe sanguin le plus rare est AB-.
                new Question(true, R.string.question_pacman, R.string.explanation_pacman), // Pac-Man est un jeu vidéo sorti dans les années 1980.
                new Question(true, R.string.question_earth, R.string.explanation_earth), // La Terre tourne autour de son axe en 24 heures.
                new Question(true, R.string.question_saturn, R.string.explanation_saturn), // Saturne a des anneaux composés principalement de glace.
                new Question(true, R.string.question_volcano, R.string.explanation_volcano), // Le Vésuve est un volcan actif en Italie.
                new Question(true, R.string.question_pizza, R.string.explanation_pizza), // La pizza est originaire d'Italie.
                new Question(true, R.string.question_moonphase, R.string.explanation_moonphase), // La pleine lune apparaît tous les 29,5 jours.
                new Question(true, R.string.question_panda, R.string.explanation_panda), // Le panda géant est originaire de Chine.
                new Question(true, R.string.question_shakespeare, R.string.explanation_shakespeare), // William Shakespeare a écrit "Roméo et Juliette".
                new Question(true, R.string.question_radio, R.string.explanation_radio), // La radio a été inventée par Guglielmo Marconi.
                new Question(true, R.string.question_france, R.string.explanation_france), // La Tour Eiffel a été construite en 1889.
                new Question(true, R.string.question_napoleon, R.string.explanation_napoleon), // Napoléon Bonaparte a été empereur de France.
                new Question(true, R.string.question_mediterranean, R.string.explanation_mediterranean), // La mer Méditerranée est bordée par trois continents.
                new Question(true, R.string.question_germany, R.string.explanation_germany), // Berlin est la capitale de l'Allemagne.
                new Question(true, R.string.question_english, R.string.explanation_english), // L'anglais est la langue la plus parlée dans le monde.
                new Question(true, R.string.question_uranus, R.string.explanation_uranus), // Uranus est la septième planète du système solaire.
                new Question(true, R.string.question_bigbang, R.string.explanation_bigbang), // La théorie du Big Bang explique l'origine de l'univers.
                new Question(true, R.string.question_neptune, R.string.explanation_neptune), // Neptune est la planète la plus éloignée du Soleil.
                new Question(true, R.string.question_hurricanes, R.string.explanation_hurricanes), // Les ouragans se forment principalement dans l'océan Atlantique.
                new Question(false, R.string.question_fungi, R.string.explanation_fungi), // Les champignons appartiennent au règne des végétaux.
                new Question(true, R.string.question_light, R.string.explanation_light), // La lumière se déplace à une vitesse de 300 000 km/s.
                new Question(true, R.string.question_strawberry, R.string.explanation_strawberry), // La fraise est un fruit.
                new Question(true, R.string.question_horses, R.string.explanation_horses), // Les chevaux sont des herbivores.
                new Question(true, R.string.question_egypt, R.string.explanation_egypt), // Les pharaons étaient les rois de l'Égypte ancienne.
                new Question(true, R.string.question_eiffel, R.string.explanation_eiffel), // La Tour Eiffel est le monument le plus visité au monde.
                new Question(false, R.string.question_atlantis, R.string.explanation_atlantis), // L'Atlantide était une civilisation avancée existant dans la réalité.
                new Question(true, R.string.question_pyramids_age, R.string.explanation_pyramids_age), // Les pyramides de Gizeh datent de plus de 4 500 ans.
                new Question(true, R.string.question_mammals, R.string.explanation_mammals), // Les baleines sont des mammifères.
                new Question(false, R.string.question_polarbears, R.string.explanation_polarbears), // Les ours polaires vivent en Antarctique.
                new Question(true, R.string.question_statueofliberty, R.string.explanation_statueofliberty), // La Statue de la Liberté a été offerte par la France aux États-Unis.
                new Question(true, R.string.question_mona_lisa, R.string.explanation_mona_lisa), // La Joconde est exposée au musée du Louvre.
                new Question(true, R.string.question_ice, R.string.explanation_ice), // L'eau gèle à 0°C.
                new Question(true, R.string.question_martin_luther, R.string.explanation_martin_luther), // Martin Luther King Jr. a mené le mouvement des droits civiques aux États-Unis.
                new Question(true, R.string.question_cheetah, R.string.explanation_cheetah), // Le guépard est l'animal terrestre le plus rapide.
                new Question(true, R.string.question_greatwall, R.string.explanation_greatwall), // La Grande Muraille de Chine a été construite pour protéger contre les invasions mongoles.
                new Question(true, R.string.question_napoleon_battle, R.string.explanation_napoleon_battle), // Napoléon a perdu la bataille de Waterloo.
                new Question(true, R.string.question_silver, R.string.explanation_silver), // L'argent est un meilleur conducteur d'électricité que le cuivre.
                new Question(true, R.string.question_wool, R.string.explanation_wool), // La laine provient principalement des moutons.
                new Question(true, R.string.question_flamingo, R.string.explanation_flamingo), // Les flamants roses tirent leur couleur de leur alimentation.
                new Question(true, R.string.question_blackhole, R.string.explanation_blackhole), // Les trous noirs ont une gravité si forte que même la lumière ne peut s'en échapper.
                new Question(true, R.string.question_planets, R.string.explanation_planets), // Il y a 8 planètes dans le système solaire.
                new Question(true, R.string.question_pearl, R.string.explanation_pearl), // Les perles se forment dans les huîtres.
                new Question(true, R.string.question_pasta, R.string.explanation_pasta) // Les spaghettis sont un type de pâtes italiennes.
        };
    }
}
