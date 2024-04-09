import React, { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';

export default function usePagination() {
  const [searchParams, setSearchParams] = useSearchParams();
  const [totalNumberOfPages, setTotalNumberOfPages] = useState(0);
  const [totalNumberOfItems, setTotalNumberOfItems] = useState(0);
  const currentPage = Number(searchParams.get('page') || 1);

  const onPageChange = (page) => {
    setSearchParams({ page });
  };

  return {
    onPageChange,
    totalNumberOfPages,
    setTotalNumberOfPages,
    totalNumberOfItems,
    setTotalNumberOfItems,
    currentPage,
  };
}
