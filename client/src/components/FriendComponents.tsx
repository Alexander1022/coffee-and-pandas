const FriendComponent = (props:any) => {
    return (
        <>
          <button className="flex items-center w-screen px-5 py-2 transition-colors duration-200 dark:hover:bg-gray-900 gap-x-2 hover:bg-gray-100 focus:outline-none">
                <img className="object-cover w- h-8 rounded-full" src="https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&h=880&q=80" />

                <div className="text-left rtl:text-right">
                    <h1 className="text-sm font-medium text-gray-700 capitalize dark:text-white">{props.name}</h1>
                </div>
            </button>  
        </>
    );
}

export default FriendComponent;