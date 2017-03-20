function FINALPROJECT

boardie


cb=randi(30,5,5)
cb(3,3)=0
rectangle('position',[60 40 20 20],'FaceColor',[0.9 0. 0.1])
%EVERYTHING DONE BEFORE THIS WAS TO MAKE THE BOARD AND THE FREE SPACE

yb=randi(30,5,5)
yb(3,3)=0
counter1=1
counter2=1
for(j=1:5)
    for(i=1:5)
   text(i*20+10,j*20-10,num2str(cb(i,j)),'FontSize',12)
   text(i*20-130,j*20-10,num2str(yb(i,j)),'FontSize',12)
    end
end
%puts the numbers on the table
rectangle('position',[60 40 20 20],'FaceColor',[0.9 0. 0.1])
rectangle('position',[-80 40 20 20],'FaceColor',[0.9 0. 0.1])

text(-80,50,'Free Square','FontSize',13)
text(60,50,'Free Square','FontSize',13)
wincb=0
winyb=0
winnercb=0
winneryb=0
notnextnum=[1,30]
cntr=1
while(winnercb==0&&winneryb==0)
    pause(0.001)
  
  nextnum=randi(30) 
  while(find(nextnum==notnextnum))
      nextnum=randi(30)
  end
  notnextnum(cntr)=nextnum
  cntr=cntr+1
  text(-10,100,'Numbers called')
  text(-40+(5*cntr),105,num2str(nextnum))
  rectangle('position',[-10 40 20 20],'FaceColor', [1,0.8,0.3])
  text(-10,45,'next number','FontSize',12) 
  text(0,50,num2str(nextnum),'FontSize',12)
  %this checks to see if the number has been called
  for(k=1:5)
      for(l=1:5)
          if((cb(k,l))==nextnum)
              save=cb(k,l)
              cb(k,l)=0;
              rectangle('position',[k*20 l*20-20 20 20],'FaceColor',[0.9 0. 0.1])
              text(k*20+10,l*20-10,num2str(save),'FontSize',12)
          end
              if((yb(k,l))==nextnum)
              save=yb(k,l)
              yb(k,l)=0;
              rectangle('position',[k*20-140 l*20-20 20 20],'FaceColor',[0.9 0. 0.1])
              text(k*20-130,l*20-10,num2str(save),'FontSize',12)
              
              end
      end
  end
  
  
  %this checks to see if a player has won
  %goes through each column row and diag to see if they have bingo
    for(i=1:5)

        winyb=((sum(yb(i,:)))==0||((sum(yb(:,i)))==0)||sum(diag(yb))==0||sum(diag(flipud(yb)))==0);
        wincb=((sum(cb(i,:)))==0||((sum(cb(:,i)))==0)||sum(diag(cb))==0||sum(diag(flipud(cb)))==0);
        if((sum(yb(i,:)))==0)
           rectangle('position',[(-120+(20*(i-1))) 0 20 100],'LineWidth',3)
        
        elseif((sum(yb(:,i)))==0)
           rectangle('position',[-120 (0+(20*(i-1))) 100 20],'LineWidth',3)
        
        elseif(sum(diag(yb))==0)
          line([-20,-120],[100,0],'LineWidth',2)
        
        elseif(sum(diag(flipud(yb)))==0)
           line([-120,-20],[100,0],'LineWidth',2)
            
        end
         if((sum(cb(i,:)))==0)
           rectangle('position',[(20+(20*(i-1))) 0 20 100],'LineWidth',3)
        
         elseif((sum(cb(:,i)))==0)
           rectangle('position',[20 (0+(20*(i-1))) 100 20],'LineWidth',3)
        
         elseif(sum(diag(cb))==0)
            line([120,20],[100,0],'LineWidth',2)
        
         elseif(sum(diag(flipud(cb)))==0)
             line([20,120],[100,0],'LineWidth',2)
         end
    
        if(wincb==1)
            winnercb=1
        end
        if(winyb==1)
            winneryb=1
        end
   
  
 
    end
    end
%displays if the player has won lost or drew
winner(winneryb,winnercb)

end





function boardie

scrsz = get(0,'ScreenSize');
width = scrsz(3); %width of the monitor
height = scrsz(4); %height of the monitor
my_color = [0.8 0.9 0.6]; %color of the figure
%set the size and position of the figure
hf =figure('Position',[20 50 round(0.8*width) round(0.85*height)]);
set(hf, 'Color', my_color); %set the color of the figure
axis([-120 120 0 100]); %set the limits on the axis
axis ij; % place the origin of the j axis on the top.
daspect([1 1 1]); % makes the axis symmetrical
haxis = gca; % give the gca (get current axis) a name
% control the axis
set(haxis,'XAxisLocation','origin','YAxisLocation','origin',...
 'Position',[0.01 0 0.9786 1])
 set(haxis, 'Visible', 'off') %uncomment this line later
for(i=0:20:100)
    for(j=-120:20:-40)
rectangle('position',[j i 20 20],'FaceColor',[1,0.8,0.3])
    end
end
for(i=0:20:100)
    for(j=20:20:100)
       rectangle('position',[j i 20 20],'FaceColor',[1,0.8,0.3])
    end
end
rectangle('position',[-10 40 20 20],'FaceColor',[1,0.8,0.3])
text(-80,-5,'your board','FontSize',12)
text(60,-5,'computer board','FontSize',12)
text(-10,10,'BINGO','FontSize',20)
text(-80,50,'Free Square')
end
 
function wins=winner(wing1,wing2)
if(wing1==1&&wing2==1)
    disp('draw')
    text(-5,75,'draw','FontSize',20)
elseif(wing1==1)
    disp('yay you won')
    text(-15,75,'yay you won','FontSize',16)
elseif(wing2==1)
    disp('oh man the computer won')
    text(-20,75,'oh man the computer won','FontSize',12)
end
end


