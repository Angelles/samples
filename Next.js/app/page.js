
   /* tutorial from Next.js - React Foundations */
   import LikeButton from "./like-button";
    function Header({ title }){ 
        return <h1>{title ? title : 'Default Title'}</h1>;
      }

    export default function Homepage(){
      const names = ['Ada Lovelace', 'Grace Hopper', 'Katherine Johnson'];
      
      

      return ( /* page contents */
            <div>
            <Header title="Develop. Preview. Ship." /> 
            <ul>
              {names.map((name) => (
                <li key={name}>{name}</li>
              ))}
            </ul>
            <LikeButton />
        </div>
        );
    }
