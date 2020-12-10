package main;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cards.*;
import view.CardCollectionMenu;


public class Main {

  public static void main(String[] args) throws IOException {
	  ArrayListCard cards = loadCards();

	  showWindow(cards);
	 
	    
//	  Serialize(cards, "Bonsoir");
//	  
//	  ArrayListCard cards2 = new ArrayListCard();
//      cards2 = Deserialize("Bonjour");	
//      System.out.println(cards2.size);
    }
  
  public static void showWindow(ArrayListCard cards) {
	  JFrame f = new JFrame("frame");
      
      //create a panel 
      JPanel p =new JPanel(); 
      
      CardCollectionMenu cardcollection = new CardCollectionMenu(p, cards);
      
      //Render the Card Collection Menu
      cardcollection.render();
 
      f.add(p); 
        
      //set the size of frame 
      f.setSize(800,1000); 
         
      f.show(); 
  }
  
  public static void Serialize(ArrayListCard cards, String fileName) {
	  try
      {
          FileOutputStream fos = new FileOutputStream("files/serialization/" + fileName);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(cards);
          oos.close();
          fos.close();
      } 
	      catch (IOException ioe) 
	      {
	          ioe.printStackTrace();
	      }
	}
  
  public static ArrayListCard Deserialize(String fileName) {
	  ArrayListCard cards = new ArrayListCard();
	  try
      {
          FileInputStream fis = new FileInputStream("files/serialization/" + fileName);
          ObjectInputStream ois = new ObjectInputStream(fis);

          cards = (ArrayListCard) ois.readObject();

          ois.close();
          fis.close();
      } 
      catch (IOException ioe) 
      {
          ioe.printStackTrace();
          return null;
      } 
      catch (ClassNotFoundException c) 
      {
          System.out.println("Class not found");
          c.printStackTrace();
          return null;
      }
	  return cards;
	  
  }
  
  public static ArrayListCard loadCards() {
	  
	  ArrayListCard cards = new ArrayListCard();
	  Card mat = new Card(0, "Le Mat", 
			  "Un homme avance vers l'horizon, une canne � la main. Il porte sur son �paule droite une besace de couleur jaune. Il est v�tu tel un p�lerin qui entamerait un voyage vers un chemin encore incertain.\r\n"
	  		+ "\r\n"
	  		+ "Derri�re lui, un animal semble s'accrocher � lui. Qu'il s'agisse d'un chien ou d'un chat, le personnage n'y accorde aucune importance et continue son chemin en d�pit des obstacles qui se pr�sentent � lui. Il semble se diriger vers un chemin incertain.\r\n"
	  		+ "\r\n"
	  		+ "Seule arcane majeure dans le tarot de Marseille � ne pas disposer d'un num�ro, le Mat est souvent plac� au d�but du cycle. La carte repr�senterait un personnage encore immature qui entamerait un chemin vers la connaissance et la sagesse.",
	  		"Vous �tes dans une situation o� vous devez faire un choix. M�me si les cons�quences semblent encore un peu floues dans votre t�te, vous �tes d�cid� � aller de l'avant et cela pourrait vous conduire � atteindre votre objectif. Certains �l�ments ou certaines personnes de votre entourage tendent toutefois � vous dissuader d'agir mais la r�ussite semble accompagner votre d�marche.",
	  		"Faites toutefois attention aux impr�vus car le personnage d�crit par le Mat montre un comportement impulsif. Essayez d'�tre attentif aux obstacles qui se pr�senteront sur votre chemin car la nonchalance et l'imprudence peuvent conduire aux pires situations. T�chez de rester coh�rent dans vos d�cisions afin de gagner en maturit�.",
	  		"Le Mat indique que vous d�tenez la solution de votre probl�me mais que vous devez vous faire comprendre. Si l'action � mener para�t floue et quelque peu confuse, faites confiance � votre intuition et allez de l'avant. Un conseil, pour arriver � un r�sultat � la hauteur de votre esp�rance, comptez sur votre d�termination et gardez en t�te votre objectif.",
	  		"Le Mat vous indique un nouveau d�part. Si vous �tes suffisamment d�termin� pour atteindre votre objectif, c'est-�-dire en mesure de faire face aux diff�rents obstacles qui se pr�sentent � vous, vous devrez parvenir � votre but . Pour cela, ayez confiance en vous, et ne perdez pas espoir. Si votre avenir semble flou, c'est que la situation que vous envisagez est nouvelle. Cela n'est pas synonyme d'�chec ou d'insucc�s. Soyez vigilant et faites preuve de prudence, prenez garde � votre libre arbitre, tant de chemins sont encore ouverts.",
	  		"Vous allez d�marrer quelque chose de nouveau, qui semble encore un peu flou dans votre t�te. Vous faites face � des impr�vus et vous ne savez pas quel chemin choisir. Le Mat laisse planer un doute sur la r�ussite de votre situation. T�chez de faire preuve de pragmatisme et gardez en vue votre objectif. Vous disposez de grandes qualit�s qui doivent vous permettre de dissiper les al�as, les incertitudes, afin de vous conduire vers une situation plus confortable.",
	  		new File("files/img/cards/1-bateleur.jpg"));
	  Card bateleur = new Card(1, "Le Bateleur",
			  "Le Bateleur repr�sente un personnage jeune qui se tient debout en face d'une table sur laquelle sont dispos�s diff�rents objets. V�tu de bleu, de rouge et de jaune, le personnage regarde sur sa droite et semble serein. Son chapeau forme un 8, symbole de l'infini, et indique une certaine forme de libert� d'actions.\r\n"
			  + "\r\n"
			  + "Dans sa main gauche, le personnage tient une baguette qui fait r�f�rence � sa ma�trise des �l�ments mat�riels. R�f�rence qui est rappel�e par les quelques objets dispos�s en face de lui : des pi�ces de monnaie, un gobelet, des d�s et un couteau.\r\n"
			  + "\r\n"
			  + "Le Bateleur est la premi�re carte du tarot de Marseille. Elle poss�de le num�ro 1 et se place au d�but du cycle.",
			  "Le Bateleur repr�sente le savoir faire, la jeunesse et l'innovation. Vous �tes sur le point de d�marrer quelque chose de nouveau et votre enthousiasme semble �tre une qualit� essentielle dans la r�ussite de votre projet. Votre comp�tence vous conf�re une certaine ma�trise de la situation mais sans effort, tout projet est vain. Vous semblez rempli de joie � l'id�e de vous engager dans cette nouvelle situation.",
			  "En revanche, vous devez garder � l'esprit que le savoir faire ne sert � rien lorsqu'il n'est pas structur� de fa�on organis�. Vous semblez engag� dans un projet sans avoir de vision � moyen terme et quand bien m�me vous disposez de toutes les comp�tences pour menez � bien votre projet, celui-ci semble ralenti par un manque d'organisation. Vous accordez trop de temps sur les choses futiles et perdez � l'esprit l'essentiel. Prenez du recul afin de mieux appr�hender votre avenir.",
			  "Souvent plac� en d�but d'un cycle conduisant � la sagesse, le Bateleur vous incite � entamer un nouveau chemin. Vous devez redevenir l'acteur de votre propre vie et mettre � profit votre exp�rience pour d�marrer quelque chose de nouveau. Laissez vous guider par votre joie de vivre et aborder l'avenir de fa�on plus mature. La r�ussite se trouvera peut �tre au rendez-vous.",
			  "Le Bateleur indique un nouveau d�part. Que ce soit sur le plan sentimental ou professionnel, vous allez prochainement entamer un nouveau d�part. Pour multiplier les chances de r�ussite de ce nouveau projet, vous devrez user de votre intelligence et de votre savoir faire afin d'entreprendre avec succ�s cette nouvelle situation.",
			  "Le Bateleur vous permet d'envisager sereinement un nouveau d�part. Vous devrez user de votre exp�rience et de la ma�trise de vos comp�tences pour mener � bien ce projet. N'h�sitez pas � aller de l'avant, mais restez vigilent : un projet bien men� est un projet r�fl�chi. Si vous pensez ne pas avoir le savoir faire pour r�ussir votre entreprise quelle qu'elle soit, ne perdez pas espoir, pers�v�rez et gagnez en comp�tence.",
			  new File("files/img/cards/0-fou.jpg"));
	  Card papesse = new Card(1, "La Papesse",
			  "La Papesse est la 2�me arcane majeure du tarot de Marseille. Son chiffre 2 symbolise tout ce qui a trait au monde f�minin. Elle repr�sente une femme d'un certain �ge qui est assise avec un livre sur les genoux.\r\n"
			  + "\r\n"
			  + "V�tue d'une grande cape bleue sous laquelle on aper�oit une robe rouge, la femme para�t repos�e et d'une grande maturit�. Elle tient un livre sur ses genoux qu'elle ne regarde pas. Il s'agit l� d'un des points cl�s de la carte. Le livre repr�sente la connaissance et son regard laisse entendre qu'elle en d�tient la cl�. On peut distinguer sur sa robe rouge deux bandes de couleur jaune que l'on peut assimiler � une serrure. Celle-ci conduirait � la connaissance et le devoir de chacun serait d'en trouver la cl�.",
			  "Vous semblez serein dans l'approche que vous choisissez pour appr�hender votre avenir. La Papesse montre une forme de sagesse dans votre attitude qui vous sera utile pour mener � bien votre projet. Laissez-vous guider par votre intuition. La maturit� qui �mane de la Papesse devrait vous permettre de conduire votre projet avec succ�s.",
			  "En revanche, la Papesse montre que vous manquez de dynamisme et de conviction dans la r�ussite de votre projet. Ne vous laissez pas aller � l'oisivet�, et gardez bien en t�te votre objectif. Vous r�fl�chissez trop avant d'agir et vous manquez sans doute de confiance en vous. R�agissez afin de mettre � profit l'ensemble de votre champ de comp�tences.",
			  "La situation � laquelle vous r�fl�chissez manque de concret. Vous avez tendance � trop r�fl�chir � votre �tat actuel et vous manquez de confiance en l'avenir. La Papesse vous indique un �v�nement nouveau � venir, qui ne s'est pas encore d�clar�. Soyez sensible aux changements qui vont arriver dans votre vie. Votre entourage pourra vous aider � passer � l'action si vous manquez de confiance en vous lorsque la situation se pr�sentera.",
			  "La Papesse met en avant un manque d'�volution dans votre situation. Vous restez enferm� dans une situation qui ne saurait vous convenir. Vous devez vous remettre en question et devenir plus actif. Sur le plan professionnel, vous vous contentez d'une situation qui pourrait �voluer � condition que vous vous en donniez les moyens. Sur le plan sentimental, vous faites preuves d'une certaines sagesse et aborder l'avenir avec calme.",
			  "La Papesse montre que vous pouvez avoir confiance en votre intuition. Vous interpr�tez avec grande facilit� les comportements de votre entourage mais vous manquez de confiance en vous pour avancer dans votre projet de vie. Soyez moins c�r�bral, et restez concentrer sur des actions concr�tes. N'oubliez pas : la Papesse se discr�dite trop souvent dans l'oisivet�.",
			  new File("files/img/cards/2-papesse.jpg"));
	  Card imperatrice = new Card(3, "L'imp�ratrice",
			  "L'Imp�ratrice repr�sente une femme assise sur un tr�ne. Elle tient dans sa main gauche un sceptre et dans sa main droite un bouclier repr�sentant un aile aux ailes d�ploy�es.\r\n"
			  + "\r\n"
			  + "L'imp�ratrice porte les embl�mes de la royaut� son tr�ne la place sur une forme de pi�destal. Son attitude lui conf�re un caract�re dominateur et son regard semble gr�ce et port� vers l'avenir.\r\n"
			  + "\r\n"
			  + "Cette lame contraste avec la Papesse (II) � laquelle elle succ�de en pr�sentant une femme d'action qui s'int�resse aux choses concr�tes. Si la Papesse semblait brid�e dans une phase de gestation, l'imp�ratrice qui lui succ�de semble plus �panouie et se focalise sur la r�alisation concr�te d'un projet.\r\n"
			  + "\r\n"
			  + "Son regard semble annoncer la lame suivante: l'Empereur, qu'elle soutient par sa f�minit� et par sa bienveillance.",
			  "Vous �tes un bon communiquant. A l'aise dans les relations que vous entretenez avec votre entourage, vous gagnez � �tre connu et votre intellect est rarement remis en question. L'Imp�ratrice montre une pr�disposition pour tout ce qui touche � l'organisation et � la mise en oeuvre d'une action. Ayez confiance en vous, vous semblez dou� pour conduire un projet.",
			  "En revanche, l'Imp�ratrice d�note une haute estime de vous m�me. Si par le pass� vous avez conduit vos projets avec succ�s, cela ne veut pas dire que vous �tes � l'abri de l'�chec. Il n'y a pas d'�quation gagnante pour mener � bien une action et vous devrez vous remettre en question afin de canaliser votre amour propre. Il faut parfois savoir s'incliner pour prendre du recul et appr�hender de mani�re objective une situation donn�e.",
			  "Afin de mener � bien votre projet, vous devrez compter sur votre intellect et sur votre force de persuasion. L'Imp�ratrice pr�sente un personnage disposant d'une grande reconnaissance sociale. Celle-ci sera essentielle dans la r�alisation de votre action. N'h�sitez pas � aller vers les autres pour leur demander de l'aide. Ces derniers sauront vous apporter le soutien n�cessaire pour que vous puissiez conduire vos actions vers la r�ussite.",
			  "L'Imp�ratrice se distingue des autres lames par sa force d'action. Vous allez faire preuve d'une grande souverainet� dans la r�alisation de votre projet. Le succ�s risque d'�tre au rendez-vous dans la mesure o� vous vous cantonner � la phase op�rationnel du projet. Vous pouvez avoir confiance dans l'avenir, car vous allez rencontrer de nouvelles personnes, et de nouveaux �v�nements vont se pr�senter � vous. Vous serez � m�me d'y faire face.",
			  "Vous �tes force de proposition et vous faites preuve d'ambition. L'Imp�ratrice montre que vous allez devoir face � une situation nouvelle. Vous devrez aborder cette situation avec pragmatisme et faire appel � toutes vos comp�tences pour choisir le bon chemin et continuer � avancer dans votre projet de vie. N'h�sitez pas � multiplier les contacts, votre app�tence pour les relations � autrui vous permet de tirer parti des interactions sociales, et cela devrait �tre essentiel dans votre qu�te du succ�s.",
			  new File("files/img/cards/3-imperatrice.jpg"));
	  Card empereur = new Card (4, "L'empereur",
			  "La lame de l'Empereur porte le num�ro 4, qui repr�sente les 4 �l�ments : la terre, l'eau, le feu et l'air. Elle succ�de � l'Imp�ratrice, et repr�sente un homme de profil assis sur un tr�ne.\r\n"
			  + "\r\n"
			  + "Il tient un sceptre en or, symbole de l'autorit� et du pouvoir. Sa couronne fait penser � un bonnet phrygien. Sur son tr�ne, appara�t un aigle aux ailes d�ploy�es. De la m�me mani�re que l'Imp�ratrice (III), sont pr�sents les embl�mes de la royaut� et du pouvoir.\r\n"
			  + "\r\n"
			  + "Le personnage semble serein et en pleine possession de ses moyens. Son attitude lui conf�re puissance, fermet�, et autorit�. Il croise sa jambe droite par dessus sa jambe gauche pour montrer que son devoir se place au dessus de son affect.\r\n"
			  + "\r\n"
			  + "Le regard droit, l'Empereur repr�sente un personnage ambitieux, qui semble anim� par une logique de conqu�te et de protection.",
			  "L'Empereur indique que vous �tes dans une situation stable. Vous accordez beaucoup d'importances aux cons�quences de vos propres actions, et vous avez des projets. Vous faites preuve d'ambition, et cela vous pousse � agir. L'empereur montre que vous �tes aptes � assumer des responsabilit�s plus importantes, mais pour cela, vous devez vous donner les moyens d'�voluer dans votre environnement social.",
			  "Vous n'avez pas toujours les r�ponses aux probl�matiques qui se pr�sentent � vous, et cela vous frustre. L'empereur montre que vous ne c�dez jamais et que vous souhaitez toujours aller au bout de ce que vous commencez. Cela peut vous conduire � vous enliser dans une situation complexe et vous avez du mal � en sortir. N'oubliez pas qu'il faut parfois trouver des compromis, afin d'avancer sur des bases plus saines.",
			  "Pour r�ussir avec succ�s votre projet de vie, vous allez devoir suivre les traces de l'Empereur. Il vous faudra faire preuve de fermet� et de conviction afin de faire valoir votre personnalit� et vos id�es. Soyez organis�, et ayez confiance en vos capacit�s. Ne n�gligez pas l'influence de votre entourage dans la r�alisation de votre projet afin d'�tre soutenu et conseill� par une figure ext�rieure.",
			  "L'empereur montre que votre projet se concr�tise. L'action que vous avez envisag�es pour mener � bien votre projet devrait porter ses fruits et clarifier votre situation. L'empereur apporte de la densit� � votre projet et montre que vos choix ont men� � des r�sultats concrets dont vous r�colt�s les fruits au quotidien. Des changements devraient se pr�senter prochainement et de mani�re concr�te dans votre vie.",
			  "L'Empereur vous pr�dit beaucoup de stabilit� dans votre situation � venir. Vous �tes sur le point d'aboutir � une situation d'�quilibre dans laquelle les choses sembleront plus simples. Votre ambition et votre motivation vous permettent d'�voluer rapidement vers un point d'�quilibre qui pourrait vous satisfaire. Gardez tout de m�me � l'esprit que la stabilit� n'est pas synonyme d'oisivet� et qu'il faut parfois savoir rester humble et modeste afin de garder les pieds sur terre.",
			  new File("files/img/cards/4-empereur.jpg"));
	  Card pape = new Card (5, "Le Pape",
			  "Le Pape porte le num�ro 5, symbole du changement. il repr�sente un personnage �g�, aux cheveux et � la barbe blancs. Il porte une tunique bleu et une cape rouge.\r\n"
			  + "\r\n"
			  + "En face de lui, deux disciples sont agenouill�s et semblent lui vouer une grande admiration. Il les b�nit de sa main droite. Son regard est plus lointain, il semble orient� vers une dimension plus large : l�infini diront certains.\r\n"
			  + "\r\n"
			  + "Il porte sur la t�te une tiare � trois �tages et tient dans sa main gauche une croix. Ces deux symboles de la papaut� renvoient l�image du patriarche, du protecteur.",
			  "Vous �tes une personne pr�venante, qui sait prendre soin d�elle et de son entourage. Vous avez en vous une belle lumi�re qui vous anime au quotidien. Votre vision des choses de la vie est claire et votre esprit est lucide. Votre c�t� chaleureux vous permet d��tre appr�ci� de vos amis et d��tre une bonne personne, avec un grand coeur et des valeurs solides.",
			  "Mais attention ! C�est bien de croire en soit, mais vous ne devez pas aller trop loin dans la confiance aveugle que vous portez � votre personne. Restez humbles et m�fiez-vous des mauvais conseils que certaines personnes de votre entourage pourraient vous donner. Restez sur vos gardes, vous risquez dans les prochaines semaines d��tre d��u par certaines choses autour de vous.",
			  "Retrouvez votre confiance. �coutez votre entourage, leurs conseils vont vous permettre de remonter la pente et de vous retrouver vous-m�me. Vous ressentez fortement ce besoin de l�cher prise, de libert�, de retour � des choses simples. Il est temps de prendre du recul sur les choses. Un s�jour � la campagne vous ferait le plus grand bien.",
			  "Vous b�n�ficiez de la protection du pape. C�est une tr�s bonne chose. Vous devez donc �tre rassur� face aux questions que vous vous posez actuellement. Vous �tes tourment� mais le bout du tunnel est proche, vous avancez tranquillement vers un avenir meilleur, sous la protection du Pape, garant de votre bonheur et succ�s futurs.",
			  "Vous �tes dans un excellent cycle ! Bient�t, le succ�s vous gagnera. Vos projets vont se r�aliser et m�me aller au-del� de vos esp�rances. Vous allez pouvoir r�aliser vos r�ves. En amour, vous allez gagner en confiance et faire de nouvelles rencontres qui vont renforcer vos relations et vous permettre de rester dans une dynamique positive. Le monde est � vous, profitez-en.",
			  new File("files/img/cards/5-pape.jpg"));
	  Card amoureux = new Card (6, "L'Amoureux",
			  "L�Amoureux porte le num�ro 6. Il repr�sente 4 personnages : un angelot, un homme et deux femmes.\r\n"
			  + "\r\n"
			  + "La femme situ�e sur la gauche de l�arcane semble plus �g�e et pose sa main sur l��paule droite de l�homme. A sa droite, la femme pose sa main sur son coeur.\r\n"
			  + "\r\n"
			  + "Au dessus de l�homme, un angelot tient un arc dans sa main. Il est entour� d�une vive lumi�re repr�sent�e par les couleurs jaune rouge et bleu. L�angelot repr�sente cupidon et ne sait pas o� tirer sa fl�che.\r\n"
			  + "\r\n"
			  + "Il semblerait que l�homme soit en phase de faire un choix entre les deux femmes. L�une repr�senterait la voie profane et l�autre la voie sacr�e. Le regard de l�homme semble diriger vers la femme la plus �g�e en d�pit des gestes d�affection entrepris par la femme situ�e sur la droite. L�Amoureux repr�sente un carrefour. L�individu est arriv� � un moment de sa vie o� il doit faire un choix : la raison ou l�amour ?",
			  "Vous �tes perdu. Vous vous retrouvez d�boussol� et ne savez plus dans quelle direction aller. Le doute vous habite, depuis plusieurs semaines d�j�. Cette situation vous rend triste et vous ne savez plus quoi faire pour en sortir. L�Amoureux est un personnage ind�cis, incertain, pris entre deux feux et ne sachant quel mode de vie choisir entre ceux qui s�offrent � lui.",
			  "Seulement vous �tes dans un immobilisme qui vous paralyse et vous emp�che de choisir entre deux situations. Vous �tes �ni oui ni non�. La peur de choisir vous habite, et vous pr�f�rez �tre dans l�attente plut�t que de prendre une mauvaise d�cision. Vous �tes passif et tourment�, vous fuyez des responsabilit�s qui pourtant vous incombent.",
			  "Vous �tes incapables, depuis plusieurs semaines, de faire un choix. Plusieurs dilemmes sont en face de vous depuis bien longtemps et vous n�arrivez pas � les arbitrer. M�fiez-vous, car dans les prochains jours, une nouvelle donne pourrait vous obliger � faire un choix contre votre gr�. Ce choix pourrait s�av�rer compliqu� � g�rer car il va �tre pris dans la pr�cipitation et dans la contrainte.",
			  "L�Amoureux vous invite � faire un choix. Vous devez cesser de tergiverser sur des situations dans lesquelles vous semblez perdus et impuissant. Prendre la d�cision d�agir, c�est d�j� un premier pas pour se sortir du cercle vicieux de la passivit�. Il est temps d�assumer vos responsabilit�s, quitte � devoir remettre en question certaines choses et vous r�orienter dans une direction nouvelle.",
			  "Il faut prendre du recul sur votre vie, essayer de r�fl�chir sur vous-m�me. Vous avez du mal � faire des choix, il est temps de reconsid�rer l�ordre des choses. Faites un point : quels sont vos objectifs actuels ? Vos envies, vos d�sirs ? Ce recul vous permettra de repartir du bon pied et de profiter plus pleinement de votre vie en refusant de vous enfermer dans des situations o� vous �tes incapable de choisir entre deux voies. Savoir o� l�on va permet de ne plus r�fl�chir sur la route � emprunter.",
			  new File("files/img/cards/6-amoureux.jpg"));
	  Card chariot = new Card (7, "Le Chariot",
			  "Le Chariot repr�sente un homme assis dans un char qui avance tir� par deux chevaux. L�homme a l�air serein et son regard semble orient� vers le lointain.\r\n"
			  + "\r\n"
			  + "Les deux cheveux avancent dans des directions diff�rentes, ce qui semblent mat�rialiser les diff�rentes possibilit�s qui s�offrent au personnage. Sous les sabots des chevaux, apparaissent des buissons auxquels ces derniers n�accordent aucune importance. Ils avancent d�un pas d�cid�, en d�pit des obstacles qui se pr�sentent � eux. L�homme ne tient pas les brides des chevaux car c�est un conqu�rant. Le chemin qu�il prend est symbolis� par son regard et non par le contr�le qu�il a sur ses chevaux.\r\n"
			  + "\r\n"
			  + "Le Chariot est une lame remplie d�espoir. Elle est lumineuse et fait appara�tre la dualit� entre la Lune (XVIII) et le Soleil (XVIIII). L�ambition affich�e par le personnage et les couleurs adopt�es rappellent les deux grandes forces pr�sentes dans le d�but du cycle : l�Imp�ratrice (III) et l�Empereur (IV).",
			  "Vous �tes un fonceur ! Vous aimez �tre dans l�action, vous ne tenez pas en place. Au travail, vous courez partout et �tes r�put� pour �tre une personnalit� stress�e. Votre d�faut ? Avoir parfois tendance � agir avant de r�fl�chir... et vous en payez parfois les pots cass�s. Le Chariot est aussi un personnage qui aime entreprendre et qui croit en sa chance.",
			  "Malheureusement vous agissez souvent mal. Vous avez un d�faut : vous manquez de confiance en vous ou, au contraire, avez une trop grande confiance en vous. Ce d�s�quilibre a tendance � vous poser des soucis lors de vos relations avec les autres. Vous passez souvent pour quelqu�un d�immature, et vous avez beau vouloir agir bien, vous vous rendez compte que souvent vos actions sont mal per�ues.",
			  "Il est temps pour vous d�aller de l�avant. Foncez ! Vos serez r�compens� de vos efforts. C�est le moment pour vous de prendre un nouveau d�part, de reconsid�rer certaines choses et de modifier vos plans. Vous devez tirer partie de votre exp�rience et vous engager dans de nouvelles choses qui vous correspondent mieux et dans lesquelles vous vous retrouverez plus facilement.",
			  "Vous �tes dans le mouvement. Les choses bougent autour de vous, et devraient continuer � bouger dans les mois qui viennent. Le Chariot vous fait bouger et vous offres des opportunit�s qui devraient se concr�tiser, tout par exemple un d�m�nagement, un nouvel emploi, ou encore une nouvelle relation.",
			  "Vos projets ont du mal � aboutir et vous n��tes pas forc�ment dans une situation de r�ussite av�r�e. Cependant, votre fougue et votre dynamisme vous permettent de continuer � avancer, d��tre toujours positif, et c�est pourquoi vos projets finiront par aboutir. Vous y mettez tout votre coeur, et c�est ce qui fera la diff�rence � l�arriv�e. Utilisez ce positivisme et cette force mentale pour avancer toujours plus loin.",
			  new File("files/img/cards/7-chariot.jpg"));
	  Card justice = new Card (8, "La Justice", 
			  "La Justice repr�sente une femme au regard s�v�re. Assise sur un tr�ne de couleur dor�e, la femme semble intransigeante et impartiale. Elle porte une tunique rouge, recouverte d�une cape bleu.\r\n"
			  + "\r\n"
			  + "Elle tient dans sa main droite une �p�e qui indique qu�elle d�tient les armes pour sanctionner. Elle se place donc en juge et semble en mesure d�interpr�ter avec la plus grande des s�v�rit�s un conflit.\r\n"
			  + "\r\n"
			  + "Dans sa main gauche, elle tient une balance parfaitement �quilibr�e. Celle-ci met en avant l�impartialit� et la neutralit� de la justice, qui sont les deux attributs garant de sa stabilit� dans une organisation.",
			  "La Justice est une personnalit� tr�s m�thodique et consciencieuse. Elle est bien �videmment honn�te et aime ce qui est juste et �galitaire. Elle sait faire preuve de diplomatie et aime le compromis. Vous avez une vie carr�e et bien organis�e, vous aimez l�anticipation et vous �tes heureux comme tout se passe comme pr�vu.",
			  "Une f�cheuse tendance � la rigidit� fait de vous une personnalit� parfois dure avec l�entourage. Les choses doivent se d�rouler comme vous l�avez pr�vu, et le moindre impr�vu vous paralyse et peut vite vous faire entrer dans un �tat d��nervement : vous avez besoin de contr�ler les choses. Vous �tes lent � changer votre fa�on de penser et � l�adapter � celle des autres.",
			  "Essayez d�agir avec mod�ration. Calmez vos ardeurs et sachez faire preuve de prudence. Prenez les �v�nements un � un et g�rez-les avec recul et intelligence. Ne cherchez surtout pas � surtout du cadre �tabli, �a n�est pas la bonne p�riode pour le faire. Pas d�initiatives trop en d�calage avec ce que vous faites habituellement. Ne franchissez pas de limites ce mois-ci, restez en recul. Une d�cision de justice peut aussi �tre attendue.",
			  "Ne vous attendez pas � un grand changement dans votre vie. Vous allez r�colter ce que vous m�ritez, rien de plus, rien de moins. Vous obtiendrez des autres ce que vous voulez bien leur donner, et n�en esp�rez pas plus, vous risqueriez d��tre d��u. La vie ne vous offrira rien gratuitement, vous devrez aller chercher les choses et vous investir.",
			  "Il faut assumer votre pass�. Vous ne reviendrez pas dessus, cessez de toujours ressasser des actions pass�es. Tournez-vous vers l�avenir, vous avez beaucoup plus � y gagner. Si vous avez un projet, sachez que pour le r�ussir vous devrez vous employer. Si vous le faites, vous r�ussirez. La Justice donne � chacun sa chance mais elle ne favorise personne.",
			  new File("files/img/cards/8-justice.jpg"));
	  Card hermite = new Card (9, "L'Hermite", 
			  "L�Hermite repr�sente un homme d�un certain �ge qui se tient appuy� sur une canne. Les trois rides sur son front forment une pyramide orient�e vers le ciel, qui symbolisent la spiritualit� de cet homme qui semble guid� par sa propre force int�rieur.\r\n"
			  + "\r\n"
			  + "L�homme tient dans sa main droite une lampe qui permet d��clairer son chemin et de pr�senter � son entourage la lumi�re qui �mane de son environnement. Sa canne est de couleur chair, ce qui montre que le chemin menant au spiritualisme et � la recherche de soi-m�me est accessible au commun des mortel.\r\n"
			  + "\r\n"
			  + "L�homme semble anim� par une qu�te profonde, ce qui donne � cette arcane une dimension occulte marqu�e.",
			  "Vous �tes un grand solitaire. Vous �tes mature et r�fl�chi, la sagesse vous habite. Vous aimez philosopher longuement que les d�tails de votre quotidien, faute de partager suffisamment vos sentiments avec des amis. Vous faites de votre solitude un atout, et avez d�velopp� depuis longtemps une personnalis� myst�rieuse dont vous n�ignorez pas qu�elle g�n�re une attirance du sexe oppos�. Vous vous demandez cependant comment la g�rer et convertir cela en relation.",
			  "Vous voil� compl�tement coup� du monde. La solitude vous mange chaque jour un peu plus. Vous vous refermez sur vous-m�me, vous avez beau faire des efforts, vous avez l�impression de reculer � chaque tentative d�avanc�e. Vous �tes perdu dans ce monde o� tout tourne autour de vous, vous en devenez m�me �go�ste et narcissique. Vous avez l�impression de ne pas compter pour les autres, alors vous leur rendez bien : ils ne comptent pas pour vous non plus. Et vous voil� dans le cercle vicieux de la timidit�.",
			  "Vous devez faire un travail sur vous-m�me. L�Hermite aime s��couter et r�fl�chir � ses probl�mes au point de se persuader qu�ils sont insolvables. Il faut sortir de ce cycle et vous ouvrir au monde, il est bien plus beau que ce que vous imaginez. �L�enfer, c�est les autres� ne doit plus �tre votre adage. M�ditez sur votre situation et allez de l�avant : rencontres, sorties, altruisme.",
			  "Concr�tiser est pour vous un processus lent et complexe. Il n�est pas impossible, mais vous allez devoir vous employer. L�Hermite a tendance � ralentir les choses. Il vous faudra faire preuve de beaucoup de pers�v�rance pour atteindre vos objectifs personnels et professionnels. Rien ne vous sera donn� gratuitement, vous devrez vous battre, mais le r�sultat sera l� pour r�compenser vos efforts.",
			  "Sentimentalement, l�Hermite n�augure rien de bon. C�est la solitude qui est sugg�r�e. Il peut s�agir d�une solitude au sens propre, ou d�une solitude au sein m�me d�un couple, lorsque l�on ne parvient pas � partager suffisamment de choses avec la personne aim�e. Vous devez agir avec maturit� et prendre des pr�cautions sur le plan du travail. Ne prenez pas de d�cision h�tive que vous pourriez regretter.",
			  new File("files/img/cards/9-hermite.jpg"));
	  Card roue = new Card (10, "La Roue de Fortune",
			  "La Roue de Fortune pr�sente roue en mouvement sur laquelle se tiennent 3 �tranges cr�atures. Celle de gauche se dirige vers le sol, qui symbolise la mati�re. Celle de droite en revanche se dirige vers le ciel, qui symbolise le spiritualisme et l�esprit. Au centre de la roue, se dispose la troisi�me cr�ature qui semble stable. Elle tient une �p�e et porte sur sa t�te une couronne qui lui conf�re autorit� et l�gitimit�.\r\n"
			  + "\r\n"
			  + "La roue pr�sente une manivelle que personne ne contr�le. Pourtant, elle semble tourner d�un mouvement perp�tuel, qui indique l�alternance des choses et le changement.\r\n"
			  + "\r\n"
			  + "La Roue de Fortune souvent per�ue comme la roue de vie et de mort symbolise le changement. Elle porte le num�ro 10 et peut �tre interpr�t�e comme la fin du premier cycle.",
			  "Vous �tes un bon vivant, capable de prendre le bon c�t� des choses et de ne pas voir le mauvais. �ternel optimiste, vous �tes un opportuniste, tant dans le monde professionnel que dans votre vie personnelle. Une occasion n�a pas besoin de se pr�senter � vous deux fois pour que vous la saisissiez : vous �tes � l'aff�t, et en recherche de bonnes affaires.",
			  "Attention � ne pas tomber dans un cercle vicieux dangereux. La surench�re est votre fa�on de fonctionner, mais il faudra parfois savoir vous calmer un peu si vous souhaitez pr�server votre famille et vos amis. Vous risquez � tout moment une crise li�e � votre fa�on de g�rer les �v�nements parfois trop impulsive et peu r�fl�chie.",
			  "Vous avez toujours eu un c�t� chanceux. Il est fortement possible que des �v�nements se produisent pour vous sortir des situations compliqu�es auxquelles vous avez � faire face. Elles pourront changer votre vie plus ou moins en profondeur, il faudra donc ne pas h�siter � saisir ces occasions pour r�soudre votre probl�matique.",
			  "Les �v�nements risquent de s�enchainer au mieux dans les prochaines semaines. Comme l�expression le dit, �la roue tourne�, et la Roue de Fortune montre clairement un renouveau rapide et positif dans votre vie. Professionnellement, une mutation peut �tre � envisager. C�t� coeur, le bonheur pourrait revenir et une relation plaisante verra le jour.",
			  "La Roue est l� pour vous montrer que vous �tes le seul ma�tre de votre destin. C�est vous qui pouvez influer dessus, c�est � vous de choisir votre vie et de tracer votre route. Personne ne pourra s�y opposer. Allez au bout de vos envies et de vos r�ves. A vous de faire tourner cette fameuse roue, � vous de la pousser aussi loin que possible.",
			  new File("files/img/cards/10-roue-fortune.jpg"));
	  Card force = new Card (11, "La Force",
			  "Cet arcane repr�sente une femme, tenant entre ses mains un chien dont elle ouvre la gueule. Cette femme domine totalement ce chien, pourtant sans grand effort. On comprend alors que c�est de la force mentale et spirituelle dont on veut parler, et non pas de la force physique et brutale.\r\n"
			  + "\r\n"
			  + "Il s�agit du num�ro 11 du tarot de Marseille. La femme est v�tue de deux couleurs dominantes : le rouge et le bleu. Le rouge est le symbole de la force et de la vitalit�, et le bleu de l�intelligence et de l�esprit.\r\n"
			  + "\r\n"
			  + "On remarque que la femme est aussi v�tue d�un chapeau de grande taille, qui fait r�f�rence � la pr�dominance de l�esprit sur la mati�re.",
			  "Vous �tes dans une maitrise totale de vous-m�me. Le courage vous anime, vous aimez les d�fis, vous �tes un fonceur. Mais l�esprit suit, c�est ce qui fait votre plus grande force : vous n�agissez pas dans la pr�cipitation, vous �tes r�fl�chi. Vous savez aller au bout de vous-m�me, vous faites preuve d�endurance dans les projets que vous menez.",
			  "Cependant, vous �tes quelqu�un de passionn� � l�extr�me. Vous avez tendance � aller trop loin lorsque vous vous investissez dans des choses. Vous �tes impatient et t�m�raire. Vous tombez facilement dans l�agressivit�, vous vous emportez tr�s vite. La force qui est en vous d�borde et n�est pas maitris�e comme elle devrait l��tre. Votre esprit est embrouill� par des sentiments impulsifs.",
			  "Vous devez travailler la maitrise de vous-m�me. Apprendre � mieux vous conna�tre, prendre du recul sur certaines choses. L�chez prise ! Ouvrez-vous � des choses moins mat�rialistes. Apprenez la patience, d�veloppez votre volont�, et retrouvez un moral positif. Foncez, mais soyez pr�t � �tre endurant. L�adage � tout vient � point � qui sait attendre � vous colle � la peau.",
			  "Vous avez projets en cours, vous irez probablement au bout. Vous avez la force pour g�rer les difficult�s qui vont se pr�senter � vous et pour les surmonter. Sachez rester endurant et courageux, vous allez en avoir grand besoin. Vos projets prennent du temps et il faut savoir faire preuve de patience pour atteindre les objectifs fix�s.",
			  "Vous allez r�ussir les projets que vous menez actuellement. Vous saurez trouver la force mentale pour aller jusqu�au bout, vous devenez endurant, vous avez la sagesse et l�exp�rience pour enfin atteindre vos objectifs. Profitez-en, c�est une p�riode faste pour vous, c�est le moment d�oser de nouvelles choses et de se fixer de nouveaux objectifs.",
			  new File("files/img/cards/11-force.jpg"));
	  Card pendu = new Card (12, "Le Pendu",
			  "Le pendu est une carte � l�envers. Le personnage est en effet suspendu par un pied � un arbre, la t�te en bas. Il a les mains li�es dans le dos. Ce pendu pourrait tout � fait �tre mort, et pourtant son visage est �tonnamment serein et confiant. Il semble dans l�attente de quelque chose, il est fig� dans une situation bien d�licate.\r\n"
			  + "\r\n"
			  + "On sent ce personnage dans une impossibilit� totale d�action ; il est d�connect� du r�el, il n�a plus les pieds sur terre.",
			  "Vous vivez une p�riode pleine d�attente et de passivit�. Attention � ne pas vous oublier et � ne pas vous �loigner trop de l�action pour tomber dans l�inaction la plus totale. Il vous est difficile d�avoir une vision � moyen-terme, vous avez du mal � vous mettre des objectifs et la procrastination a tendance � vous mettre des b�tons dans les roues.",
			  "Cependant il est clair que vous subissez un tr�s gros blocage dans votre vie. Il peut s�agir d�un blocage sentimental, d�une difficult� � aimer � nouveau une personne ou � �tre aim�. Vous �tes dans l�attente, vous �tes immobiles, vous �tes paralys� par un �v�nement ou une personne. Un obstacle vous para�t infranchissable et vous emp�che d�avancer.",
			  "Vous devez ralentir, patienter, attendre. Des �v�nements se succ�dent trop vite autour de vous, il est venu le temps de prendre du recul et de vous poser quelques instants. Ne soyez pas press� d�aboutir � un r�sultat, restez en retrait, sachez vous effacer et analyser les situations avant d�agir � nouveau. Vous gagnerez en exp�rience et pourrez avoir une vision diff�rente des �v�nements qui vous aidera � les surmonter.",
			  "La r�ponse est l�attente, le blocage. Vos projets n�aboutissent pas encore et pourraient prendre une tournure probl�matique. Vous devez attendre, laisser passer un peu de temps. Soyez plut�t dans l�inaction et dans la passivit� afin d��viter de faire de mauvais choix. Il vaut parfois mieux ne rien faire que de se pr�cipiter et faire des erreurs : il est toujours difficile de revenir en arri�re.",
			  "Le Pendu vous indique ici la n�cessit� d�attendre. Vous �tes dans une situation de blocage en termes de communication, de blocage dans vos projets, de blocage sentimental, ou de blocage dans le cadre de votre travail. Le Pendu vous demande de prendre sur vous et d�attendre. Essayez peut-�tre de l�cher un peu prise, tout en restant dans une situation d�attente.",
			  new File("files/img/cards/12-pendu.jpg"));
	  Card arcanne = new Card (13, "L'Arcane Sans Nom (La Mort)",
			  "Sur cette carte on peut voir un squelette courb�, qui tient dans sa main une faux. Symboles de la mort, ces deux �l�ments nous orientent sur la signification de la carte.\r\n"
			  + "\r\n"
			  + "Le squelette est pench� vers l�avant et � ses pieds on remarque d�autres morceaux de squelettes (quelques mains, quelques t�tes). L�ambiance de la carte est tr�s n�gative.",
			  "Vous savez vous remettre en question et avez franchi une �tape importante dans votre vie. C�est la fin de quelque chose, probablement la fin d�une p�riode difficile qui s�ach�ve enfin. Vous avez atteint un but, une limite, un objectif. Un projet arrive � son terme ou prend une autre dimension. Tournez la page, il est temps d��crire la suivante.",
			  "Mais vous �tes dans la n�gation de la r�alit�. Vous refusez de voir que quelque chose a chang� autour de vous. C�est la fin d�une situation, peut-�tre la fin d�une relation amoureuse ou d�une relation de travail. Il est difficile d�admettre certaines choses, surtout lorsqu�il s�agit de la fin d�une p�riode qui fut heureuse.",
			  "Il vous faut envisager une rupture. Un de vos projets doit se terminer, trop d��nergie a �t� d�pens�e. Vous devez mettre un terme � une relation ou en revoir les conditions. Une transformation est n�cessaire dans votre vie afin de retrouver une dynamique positive. C�t� travail, il est possible qu�un changement soit opportun et qu�il serait bien accueilli par votre entourage.",
			  "Reconsid�ration totale de votre projet, de votre relation, de vos id�es ou encore de votre fa�on de mener votre vie. C�est une annonce proche de vous : ce bouleversement dans votre vie devrait arriver rapidement. Il est n�cessaire pour vous permettre de continuer � avancer. Une limite a �t� atteinte, il faut la surpasser.",
			  "C�est une n�cessit� pour vous de d�clencher une rupture par rapport � votre vie actuelle. Il faut savoir mettre fin � certaines choses pour en d�couvrir de nouvelles. Vous risquez de traverser un bouleversement important mais vous trouverez les forces pour y faire face. Le changement doit avoir lieu maintenant, il ne faut pas en avoir peur.",
			  new File("files/img/cards/13-mort.jpg"));
	  Card temperance = new Card (14, "La Temp�rance", 
			  "Il s�agit d�un ange, qui tient entre ses mains deux amphores. Ce personnage semble faire circuler un fluide de l�un � l�autre. Sa t�te est pench�e vers la droite et son regard est apaisant. Au dernier plan, on remarque un paysage simpliste mais joli et positif.\r\n"
			  + "\r\n"
			  + "Cet ange a deux ailes �tendues derri�re elle, qui lui donnent le pouvoir de voler. Elle b�n�ficie de cette force tout en faisant preuve d�une grande tranquillit� sur terre.",
			  "Vous vous sentez bien dans votre peau, droit dans vos bottes. Vous �tes sociable et savez vous montrer pertinent et int�ressant en soci�t�. Votre gentillesse vous offre les faveurs de vos amis et votre succ�s vous offre l�opportunit� de vous faire valoir. Vous �tes une personnalit� int�ressante, vivante, heureuse.",
			  "Mais vous avez de gros soucis de communication. Les gens autour de vous ont du mal � vous comprendre et les messages que vous envoyez ne trouvent souvent pas de r�cepteur. Vous manquez de confiance en vous et de s�r�nit�. Vous prenez le risque d�abandonner des projets qui vous tiennent pourtant � c�ur.",
			  "Vous devez communiquer d�avantage avec vos proches et votre entourage. Vous devez temp�rer votre caract�re et rester calme lorsque des situations qui vous d�passent se pr�sentent. Pensez aussi � mod�rer vos ardeurs professionnelles et amoureuses, vous gagnerez en cr�dibilit� aupr�s de votre entourage et serez gagnant sur le long terme.",
			  "Concr�tisation, renouveau et r�ussite. Vos projets vont aboutir dans la s�r�nit� et le calme. Vous allez atteindre vos objectifs sans avoir � lutter ou � forcer votre chance. Vous �tes dans une bonne dynamique : profitez-en. Le succ�s vous attend tranquillement, laissez-vous porter jusqu�� lui. Vous pourrez alors planifier de nouveaux projets que vous mettrez en �uvre avec succ�s.",
			  "La Temp�rance vous apportera le succ�s attendu. Cependant, il faudra rester humble et ne pas h�siter � faire quelques concessions. Vous pourrez ainsi atteindre une meilleure harmonie dans votre vie. Vous rencontrerez des difficult�s que vous pourrez franchir avec patience et volupt�. Dans votre vie amoureuse, vous allez vers une am�lioration et vers l�aboutissement tranquille d�une relation.",
			  new File("files/img/cards/14-temperance.jpg"));
	  Card diable = new Card (15, "Le Diable", 
			  "Cette carte comporte trois personnages. L�un est sur un pi�destal, et poss�de deux grandes ailes dans son dos. Il poss�de aussi deux cornes sur sa t�te. Il tient dans sa main gauche une �p�e par la pointe. Son visage est surprenant et semble souriant : il tire la langue.\r\n"
			  + "\r\n"
			  + "Les deux personnages en contrebas sont enchain�s � lui, et se font face l�un l�autre.",
			  "Vous �tes un cr�atif ! Vous aimez imaginer, cr�er, inventer. Vous �tes un malin, et vos amis le savent. Mais vous pouvez aussi vous montrer parfois calculateur et cela ne pla�t pas � tout le monde. Vous fonctionnez � l�intuition et aimez faire les choses rapidement, avec les gens que vous aimez. Vous d�bordez d��nergie et d�envies, mais manquez parfois d�organisation.",
			  "Malheureusement vous faites face � de nombreuses difficult�s. Vous �tes esclave de vous-m�me et il vous est difficile de vous en sortir. Vous avez pu vous emp�trer dans des situations complexes et malsaines : de sales histoires dans lesquelles vous vous �tes retrouv� sans trop comprendre pourquoi ni comment.",
			  "Vous allez b�n�ficier d�une vague positive qu�il faudra savoir g�rer. C�est � prendre ou � laisser. Cette phase ne sera pas facile � g�rer et vous demandera beaucoup d��nergie. Cependant si vous parvenez � maitriser ceci, votre vie avancera grandement et vous franchirez un v�ritable cap. Sachez prendre cet �v�nement comme une chance � saisir.",
			  "Le Diable vous procure une �nergie qu�il sera difficile de contr�ler. Vous risquez de perdre pied. Vos projets seront alors compliqu�s � concr�tiser. Vos relations conflictuelles et t�ch�es par des incompr�hensions. Vous aurez du mal � ma�triser les situations dans lesquelles vous allez �tre plong� quotidiennement.",
			  "Avec le Diable, vous risquez de vous retrouver dans une situation de trouble. Vous devez rester sur vos gardes et vous m�fier de certains pi�ges dans lesquels vous pourriez tomber. Sur le plan professionnel, m�fiez-vous de vos coll�gues qui pourraient vous faire un mauvais coup. Sur le plan amoureux, ne laissez pas d�g�n�rer une situation d�j� mal embarqu�e.",
			  new File("files/img/cards/15-diable.jpg"));
	  Card maison = new Card (16, "La Maison-Dieu",
			  "La maison-Dieu, �galement appel� La Tour, repr�sente un �difice sur lequel s�abat la foudre. Deux personnages semblent s��chapper de l��difice. La s�r�nit� sur leur visage est signe que leur chute n�est pas dramatique. Ils semblent �tre en suspension dans l�air, sans se soucier de la tour qui s�effrondre.\r\n"
			  + "\r\n"
			  + "Au soleil, observe un champ de couleur jaune avec quelques touffes d�herbe verte qui sugg�re que la vie est pr�sente autour de l��difice et ce malgr� l'effondrement de la tour.\r\n"
			  + "\r\n"
			  + "Ne vous m�prenez pas, si la tour s�effondre, les couleurs et le tons adopt�s sur la lame de la Maison-Dieu ont une connotation tr�s positive qui sugg�re une crise salutaire.",
			  "Vous traversez une p�riode difficile. Vous risquez fortement de vivre une d�sillusion. M�fiez-vous de votre entourage, particuli�rement professionnel. D�stabilis�, quelque chose ne tourne pas rond dans votre vie et vous le ressentez. Vous manquez de discernement de ne sachez plus comment vous sortir de cette situation bien embarrassante.",
			  "Il y a l� une s�rieuse mise en garde sur un risque d��chec que vous courrez, et que vous n�auriez pas identifi�. Il peut s�agir d�un �chec professionnel ou d�un �chec d�ordre personnel. Le fait de ne pas avoir vu venir ce risque va vous blesser �norm�ment et vous refroidir. Il n�est pas certain que votre projet sera pour autant impossible � r�aliser. Mais il y a ici un avertissement tr�s clair.",
			  "Vous courrez un risque d��chec. Il faut reconsid�rer votre projet, repartir � z�ro sur des bases diff�rentes. Vous vous �tes trop engag� trop rapidement dans quelque chose qui ne vous correspond probablement pas. M�fiez-vous donc, et pensez qu�il est toujours temps de revenir en arri�re, cela vous �vitera bien des soucis.",
			  "Vous vous acheminez petit � petit vers un �chec assez cuisant. Il vous faut absolument reconsid�rer l�ordre �tabli. Vous risquez une rupture, voir m�me un divorce. Votre vie sentimentale va devenir plus compliqu�e qu�elle ne l�est actuellement, et vous devrez changer quelque chose pour revenir � une situation plus stable et confortable.",
			  "Vous �tes dans un processus in�vitable. Vous allez subir un �chec, ou du moins une reconsid�ration ou un gros changement de cap. A vous de bien le g�rer pour qu�il soit positif dans votre vie et ne vous apporte que du mieux. Il sera peut-�tre difficile de prendre la d�cision de ce changement, mais il s�av�rera salutaire pour l�avenir.",
			  new File("files/img/cards/16-maison-dieu.jpg"));
	  Card etoile = new Card (17, "L'�toile", 
			  "L�Etoile repr�sente une femme d�nud�e qui verse le contenu de deux vases rouge dans un cours d�eau. Son visage exprime douceur et s�r�nit�. Au dessus de sa t�te, 6 �toiles jaune, rouge et bleu encadrent une �toile plus volumineuse et particuli�rement lumineuse repr�sent�e � l�aide de deux couleurs fortes : le jaune et le rouge.\r\n"
			  + "\r\n"
			  + "Cette lame porte en elle une dimension cosmique et inspire la confiance. Les �toiles ont toujours servis de rep�res aux hommes et ont une dimension occulte. En tant que guide, l�Etoile doit �tre un moyen de trouver son chemin dans ce vaste univers dans lequel nous �voluons.",
			  "Vous �tes quelqu�un de sensible qui r�ussi dans la vie. Vous avez l�esprit d�entreprise et aimez aller de l�avant, vous connaissez en g�n�ral le succ�s dans ce que vous faites, c�est ce qui fait votre force. Votre entourage vous juge comme quelqu�un d�agr�able et de raffin� qui sait faire plaisir aux autres et qui sait trouver les bons mots en toutes situations.",
			  "Attention, vos projets sont irr�alistes. Vous avez �norm�ment d�ambition, d�envies, de r�ves, mais il faut savoir se mod�rer. Vous ne pourrez pas tous les r�aliser, et pourtant vous croyez pouvoir le faire. Vous �tes un doux r�veur, trop souvent dans votre bulle et vous ne voyez pas le monde tel qu�il est vraiment.",
			  "Les espoirs que vous avez ont de bonnes chances d�aboutir. Il vous faut pour cela faire appel � votre capacit� cr�ative, � votre �motivit�, et votre sensibilit�. Ne soyez pas trop inquiets, si vous parvenez � r�unir tous vos talents et toutes vos capacit�s mentales et physiques, vous parviendrez � vos objectifs sans aucune difficult�.",
			  "Un d�nouement heureux est en vue. Vous �tes dans un bon cycle et l�avenir est tout aussi positif. Vos projets, vos envies, vos r�ves, devraient se r�aliser. Votre c�t� artistique vous donne une force qui vous permettra d�aller de l�avant et d�aller jusqu�� la r�alisation de vos projets. Sentimentalement vous irez l� o� vous avez envie d�aller, vous �tes port� par un amour sinc�re.",
			  "Ne vous faites pas de soucis, vous �tes dans une tr�s bonne dynamique. Les situations vont vers le mieux et vous devriez atteindre une p�riode heureuse. Votre forte sensibilit� vous rend craintif mais vous donne aussi la force d�aller jusqu�au bout des choses. Vous en serez r�compens� car le succ�s est au rendez-vous.",
			  new File("files/img/cards/17-etoile.jpg"));
	  Card lune = new Card (18, "La Lune", 
			  "La Lune repr�sente un astre de couleur bleue qui surplombe le monde et impose sa lumi�re symbolis�e par des rayons de couleurs rouge blanche et bleue. Des gouttes de couleurs rouges, jaunes et bleues semblent �maner de la terre et se diriger en direction de la lune. Elles donnent � cette lame une dimension occulte.\r\n"
			  + "\r\n"
			  + "De chiens apparaissent la t�te dress�e vers cet astre et semblent hurler. Cela donne un c�t� chaotique � la carte qui renvoie aux angoisses primitives des �tres vivants.\r\n"
			  + "\r\n"
			  + "En contrebas de la lame appara�t un crustac� qui ressemble � une �crevisse. Celui-ci semble plong� dans une eau profonde et tente de s�en sortir. Il fait r�f�rence � notre fort int�rieur et �voque sur un plan symbolique le subconscient des �tres vivants.\r\n"
			  + "\r\n",
			  "Vous vous faites beaucoup de soucis ces derniers temps. Vous �tes emp�tr� dans une situation qui semble ne plus avancer. Vous �tes embourb� et en avez conscience, mais ne parvenez pas � vous sortir de cette f�cheuse situation. L�angoisse vous gagne, vous vous sentez impuissant face � des �v�nements qui vous d�passent.",
			  "Mais vous vous laissez envahir par vos angoisses et vos phobies. Elles prennent le dessus sur vous, parvenant m�me � effacer votre personnalit� pour vous faire devenir une personne diff�rente de celle que vous �tiez. Vous avez conscience de vos d�rives mais ne parvenez pas � r�gler le probl�me du fait de votre peur de tout et de vos terribles craintes.",
			  "La Lune vous sugg�re l�attente. Vous n��tes pas en mesure d�agir pour g�rer convenablement les �v�nements auxquels vous faites face, vous devez donc vous r�fugier dans l�attente. Profitez-en pour vous recentrer sur vous-m�me, et tenter de chasser vos doutes et vos phobies. Vos projets professionnels comme personnels restent au point mort.",
			  "Les situations auxquelles vous faites face actuellement vous d�passent. Elles risquent de conna�tre une descente dans le mois qui vient. Les choses ne s�am�lioreront pas, et risquent m�me de se d�t�riorer. Vos projets resteront � l��tat de projet. Ils ne sont pas pr�ts d��voluer par manque d�investissement de votre c�t�. Vous �tes trop �trangers � ce qui vous entoure en ce moment.",
			  "La Lune vous am�ne une situation de doute et d�incertitude. Elle fait planer sur vous un voile sombre, qui n�augure rien de bon pour l�avenir. Les situations ne risquent pas de s�am�liorer du jour au lendemain, et il faudra du temps pour revenir � une phase tr�s positive. En amour, m�fiez-vous des engagements trop rapides et des promesses.",
			  new File("files/img/cards/18-lune.jpg"));
	  Card soleil = new Card (19, "Le Soleil", 
			  "Le Soleil repr�sente un astre lumineux incarnant le visage d�un �tre humain avec des yeux, un nez et une bouche. Ils rayonnent sur la terre et ses rayons semblent apporter de la lumi�re � cette lame � dominante jaune.\r\n"
			  + "\r\n"
			  + "A l�inverse de La Lune, les gouttes semblent se diriger du soleil vers la terre et symbolisent la fertilit� et la chaleur. Le Soleil apporte � l�homme l��nergie et les richesses n�cessaires � son �panouissement. Contrairement � La Lune qui renvoie � la figure maternelle, le Soleil renvoie � la masculinit�, au visage du p�re.\r\n"
			  + "\r\n"
			  + "Plus bas, deux enfants se tiennent debout l�un en face de l�autre et semblent �blouis par le rayonnement du soleil. Ces derniers semblent heureux, prot�g�s et �voquent l'insouciance et le bonheur.",
			  "Le Soleil vous apporte toute la chaleur n�cessaire � la r�ussite de vos projets et de votre vie personnelle. Il est votre alli� dans les t�ches du quotidien. Il est votre protecteur, et vous permet de rester chaleureux, cr�atif. Vous �tes ma�tre de votre vie et vous le savez, le soleil vous aide � dominer vos peurs et � avancer toujours plus.",
			  "Votre orgueil va vous perdre. Vous vivez dans une illusion, celle d�un contr�le total de votre vie par votre personne. Cela vous emp�che de voir certaines choses que votre entourage remarque et qui risquent de vous nuire � moyen terme. M�fiez-vous de vous-m�me, apprenez � bien vous conna�tre et ne vous voilez pas la face sur vos capacit�s ou vos chances d�atteindre certains objectifs.",
			  "Le Soleil vous prot�ge contre les soucis de la vie. Cependant il est aussi l� pour vous montrer que vous devez aller de l�avant, et mobiliser toutes les forces qui sont en vous. Votre sensibilit�, votre curiosit� et votre courage devront �tre r�unis pour avancer et r�soudre vos soucis. Vous y parviendrez sans aucun doute, mais il faudra y mettre du votre.",
			  "R�ussite sur tous les plans. R�ussite professionnelle d�abord : une promotion peut arriver, ou un changement de poste avec un salaire plus int�ressant. R�ussite personnelle ensuite : tout va bien dans vos relations, et de nombreux �l�ments vous prouvent chaque jour que vous plaisez au sexe oppos� et que vous �tes dans une tr�s bonne dynamique sur ce plan.",
			  "Le Soleil est une jolie preuve de r�ussite. Cette carte en synth�se ne laisse pas le moindre doute : vous �tes en route vers le succ�s. Vos talents personnels, votre investissement, et la pr�cieuse aide de votre entourage, vont vous permettre d�aller au bout de projets dans lesquels vous avez beaucoup mis d�espoirs, depuis de nombreux mois.",
			  new File("files/img/cards/19-soleil.jpg"));
	  Card jugement = new Card (20, "Le Jugement", 
			  "La lame d�crit un angelot tenant une trompette sur laquelle est accroch�e un drapeau. L�ange semble flotter dans les nuages bleus et regarder le monde des vivants. Depuis les nuages, �manent des rayons de couleurs jaunes et rouges qui indiquent le rayonnement du ciel sur la terre.\r\n"
			  + "\r\n"
			  + "Le Jugement pr�sente 3 individus. Le personnage au centre se tient de dos tandis qu�une femme et un homme se tiennent � ses c�t�s et semblent prier.\r\n"
			  + "\r\n"
			  + "Le Jugement renvoie � l�id�e de vie et de mort et fait r�f�rence � l'au-del�. Il apporte une note d�esp�rance dans la mesure o� il rappelle � l��tre humain la dualit� qui existe entre le terrestre et le divin.",
			  "Vous �tes sans aucun doute parvenu � une phase de renouveau total dans votre vie. Tant sur le plan sentimental que sur le plan professionnel o� l�on voit clairement des �volutions, vous avez su prendre votre vie en main et aller de l�avant. Vous avez chang� votre prisme de r�flexion et vous voyez maintenant le verre � moiti� plein au lieu de voir le verre � moiti� vide. Bravo, l�avenir vous est ouvert.",
			  "Vous �tes tr�s influen�able et cela va vous jouer des tours. Vous avez l�impression de ma�triser les choses, mais vous �tes guid�s par des personnes qui jouent avec vous. Vous manquez de recule et vous persuadez de choses qui n�existent pas. Des �v�nements ext�rieurs risquent de venir perturber votre quotidien et vous aurez du mal � trouver des solutions.",
			  "Vous devez changer votre champ de vision. De nombreuses choses vous �chappent dans votre vie et cela ne peut plus durer. Votre entourage s�en rend compte et vous envoie des messages plus ou moins clairs. A vous de vous relever en sortant du cadre et en r�inventant certains aspects de votre personnalit�. Vous devez aller de l�avant.",
			  "Vous allez �voluer tr�s positivement ces prochains mois. Vous avez pris des d�cisions difficiles et vous voil� dans un nouveau cycle tr�s positif. Votre entourage a remarqu� ces changements et vous le fait savoir. Vous pouvez d�sormais vous lancer dans de nouveaux projets qui ont toutes les chances d��tre couronn�s de succ�s.",
			  "Le Jugement vous apporte des changements rapides dans votre vie. Ces changements seront bien accueillis et tr�s positifs pour vous. Sur le plan professionnel, il peut s�agir d�une mutation inattendue, ou bien d�une offre d�emploi � laquelle vous ne vous attendiez pas. Sur le plan amoureux, vous ferez de nouvelles rencontres qui risquent de vous bouleverser.",
			  new File("files/img/cards/20-jugement.jpg"));
	  Card monde = new Card (21, "Le Monde", 
			  "Derni�re arcane du cycle, Le Monde repr�sente une femme d�nud�e qui se tient sur sa jambe droite. Elle semble en totale ad�quation avec son environnement. Autour d�elle, est dispos�e une couronne de laurier de diff�rentes couleurs, qui donne � cette femme une dimension universelle. La femme tient dans ses mains les outils qui se pr�sentaient devant le Bateleur (I) au d�but du cycle et semble ma�triser parfaitement les diff�rents �l�ments qui composent cette arcane.\r\n"
			  + "\r\n"
			  + "Au quatre coins de la carte, on observe un ange, une vache, un aigle, et un lion qui sont les symboles des 4 �vang�listes Saint Mathieu, Saint Luc, Saint Jean et de Saint Marc. Il place le divin autour de cette femme qui observe le lien qui existe entre l�univers et le sacr�.\r\n"
			  + "\r\n"
			  + "Le personnage est arriv� au bout de son cycle et semble avoir acquis les connaissances n�cessaires � la compr�hension de son environnement et � sa place dans le monde.",
			  "Les plan�tes sont avec vous ! Vous �tes chanceux, vous avez le destin entre vos mains. Vous avez les capacit�s pour r�ussir dans ce que vous voulez, c�est une chance unique. Le Monde vous appartient, � vous d�en profiter et d�en tirer les b�n�fices les plus forts. Vos projets seront couronn�s de succ�s et votre entourage plein de reconnaissance envers vos qualit�s.",
			  "Un tr�s gros obstacle va vous barrer la route. Le projet que vous menez actuellement risque m�me d��tre interrompu. Cet obstacle sera inattendu et de forte taille, il ne d�pendra pas de vous mais viendra de l�ext�rieur. Le Monde va vous jouer un triste tour, et vous devrez redoubler d�efforts si vous souhaitez mener � bien vos projets.",
			  "Vos chances de r�ussite sont plus fortes que jamais. A vous d�utiliser au mieux les ressources dont vous disposez pour les convertir. Professionnellement vous allez remporter de gros contrats et cr�er des jalousies autour de vous. C�t� coeur vous �tes envahi par une lumi�re enchant�e qui vous couvre de bonheur et restera longtemps avec vous.",
			  "Vous allez atteindre la gloire et la reconnaissance de tous vos pairs. C�est une obtention de dipl�me, la r�ussite d�une formation. C�est aussi un client satisfait par votre travail, un patron qui vous f�licite, des coll�gues qui vous savent indispensable. Votre coeur est rempli de joie et vous g�n�rez autour de vous des sourires et de la chaleur.",
			  "Vous atteignez l��tat de gr�ce. Votre succ�s est total. Le Monde vous a offert un formidable cadeau, et vous allez maintenant pouvoir en profiter. Votre entourage est fier de vous. C�t� coeur, la vie � deux va pouvoir reprendre tranquillement, comme lors des plus belles p�riodes. La Terre continue � tourner, et vous aussi : vous rayonnez de bonheur dans une sph�re de succ�s et de r�ussite.",
			  new File("files/img/cards/21-monde.jpg"));
	  
	  cards.add(mat);cards.add(bateleur);cards.add(papesse);cards.add(imperatrice);cards.add(empereur);cards.add(pape);cards.add(amoureux);cards.add(chariot);cards.add(justice);cards.add(hermite);cards.add(roue);cards.add(force);cards.add(pendu);cards.add(arcanne);cards.add(temperance);cards.add(diable);cards.add(maison);cards.add(etoile);cards.add(lune);cards.add(soleil);cards.add(jugement);cards.add(monde);
	  
	  return cards;
  }
  
}